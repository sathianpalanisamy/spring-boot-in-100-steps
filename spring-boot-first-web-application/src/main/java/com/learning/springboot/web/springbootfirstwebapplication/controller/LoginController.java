package com.learning.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET,path = "/login")
	@ResponseBody
	public String loginMessage() {
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/loginview")
	public String loginView(@RequestParam String name,ModelMap modelMap) {
		modelMap.put("name", name);
		return "login";
	}

}
