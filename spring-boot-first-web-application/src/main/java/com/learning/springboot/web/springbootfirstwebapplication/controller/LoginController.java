package com.learning.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.springboot.web.springbootfirstwebapplication.model.Login;
import com.learning.springboot.web.springbootfirstwebapplication.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET,path = "/hello-world")
	@ResponseBody
	public String helloWorldMessage() {
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "/login")
	public String showLoginPage(ModelMap modelMap) {
		modelMap.addAttribute("login", new Login());
		return "login";
	}
	
//	@RequestMapping(method = RequestMethod.POST,path = "/login")
//	public String showWelcomePage(ModelMap modelMap,@RequestParam String name,@RequestParam String pass) {
//		boolean isValidUser = loginService.validateCredentials(name, pass);
//		if(!isValidUser) {
//			modelMap.put("errorMessage", "Invalid Credentials");
//			return "login";
//		}
//		modelMap.put("name", name);
//		modelMap.put("pass", pass);
//		return "welcome";
//		
//	}
	
	
	@RequestMapping(method = RequestMethod.POST,path = "/login")
	public String showWelcomePage(ModelMap modelMap,@ModelAttribute("login") Login login) {
		boolean isValidUser = loginService.validateCredentials(login.getName(), login.getPass());
		if(!isValidUser) {
			modelMap.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		modelMap.put("name", login.getName());
		return "welcome";
		
	}

}
