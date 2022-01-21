package com.learning.springboot.web.springbootfirstwebapplication.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.springboot.web.springbootfirstwebapplication.service.ToDoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private ToDoService doService;
	
	@RequestMapping(method = RequestMethod.GET,path = "list-todos")
	public String getTodos(ModelMap modelMap) {
		modelMap.put("todos", doService.retrieveTodos((String)modelMap.get("name")));
		return "list-todos";
		
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "add-new-todo")
	public String addNewTodo() {
		return "add-new-todo";
	}
	
	@RequestMapping(method = RequestMethod.POST,path = "add-new-todo")
	public String updateTodo(ModelMap modelMap,@RequestParam String desc) {
		doService.addTodo((String)modelMap.get("name"), desc, new Date(), false);
		return "redirect:/list-todos";
		
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "delete-todo")
	public String deleteTodoById(@RequestParam int id) {
		doService.deleteTodo(id);
		return "redirect:/list-todos";
	}

}
