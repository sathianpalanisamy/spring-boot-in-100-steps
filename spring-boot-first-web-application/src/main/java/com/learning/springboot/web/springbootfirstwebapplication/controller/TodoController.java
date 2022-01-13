package com.learning.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.learning.springboot.web.springbootfirstwebapplication.service.ToDoService;

@Controller
public class TodoController {
	
	@Autowired
	private ToDoService doService;
	
	@RequestMapping(method = RequestMethod.GET,path = "list-todos")
	public String getTodos(ModelMap modelMap) {
		modelMap.put("todos", doService.retrieveTodos("sathian"));
		return "list-todos";
		
	}

}
