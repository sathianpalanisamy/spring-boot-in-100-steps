package com.learning.springboot.web.springbootfirstwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.springboot.web.springbootfirstwebapplication.model.ToDo;
import com.learning.springboot.web.springbootfirstwebapplication.service.ToDoService;

@Controller
//@SessionAttributes("name")
public class TodoController {

	@Autowired
	private ToDoService doService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(method = RequestMethod.GET, path = "list-todos")
	public String getTodos(ModelMap modelMap) {
		modelMap.put("todos", doService.retrieveTodos(getLoggedInUserName(modelMap)));
		return "list-todos";

	}

	private String getLoggedInUserName(ModelMap modelMap) {
//		return (String)modelMap.get("name");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	@RequestMapping(method = RequestMethod.GET, path = "add-new-todo")
	public String addNewTodo(ModelMap model) {
		model.addAttribute("todo", new ToDo(0, getLoggedInUserName(model), "Default Desc", new Date(), false));
		return "add-new-todo";
	}

//	@RequestMapping(method = RequestMethod.POST,path = "add-new-todo")
//	public String updateTodo(ModelMap modelMap,@RequestParam String desc) {
//		doService.addTodo((String)modelMap.get("name"), desc, new Date(), false);
//		return "redirect:/list-todos";
//		
//	}

	@RequestMapping(method = RequestMethod.POST, path = "add-new-todo")
	public String updateTodo(ModelMap modelMap, @Valid @ModelAttribute("todo") ToDo todo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "add-new-todo";
		}
		doService.addTodo(getLoggedInUserName(modelMap), todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";

	}

	@RequestMapping(method = RequestMethod.GET, path = "delete-todo")
	public String deleteTodoById(@RequestParam int id) {
		if (id == 1) {
			throw new RuntimeException("Failed to delete");
		}
		doService.deleteTodo(id);
		return "redirect:/list-todos";
	}

	@RequestMapping(method = RequestMethod.GET, path = "update-todo")
	public String getUpadeTodoPageByid(@RequestParam int id, ModelMap modelMap) {
		ToDo todo = doService.retrieveTodoById(id);
		modelMap.addAttribute("todo", todo);
		return "add-new-todo";
	}

	@RequestMapping(method = RequestMethod.POST, path = "update-todo")
	public String updateTodoByid(@ModelAttribute("todo") @Valid ToDo todo, BindingResult bindingResult,
			ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			return "add-new-todo";
		}

		todo.setUser(getLoggedInUserName(modelMap));
		doService.updateTodo(todo);
		return "redirect:/list-todos";
	}

}
