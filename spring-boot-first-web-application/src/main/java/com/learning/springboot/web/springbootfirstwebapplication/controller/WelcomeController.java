package com.learning.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("name")
public class WelcomeController {

//	@Autowired
//	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET, path = "/")
//	@ResponseBody
	public String showWelcomePage(ModelMap map) {
		map.put("name", getLoggedInUserName(map));
		return "welcome";
	}

	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

//	@RequestMapping(method = RequestMethod.GET, path = "/login")
//	public String showLoginPage(ModelMap modelMap) {
//		modelMap.addAttribute("login", new Login());
//		return "login";
//	}

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

//	@RequestMapping(method = RequestMethod.POST, path = "/login")
//	public String showWelcomePage(ModelMap modelMap, @ModelAttribute("login") Login login) {
//		boolean isValidUser = loginService.validateCredentials(login.getName(), login.getPass());
//		if (!isValidUser) {
//			modelMap.put("errorMessage", "Invalid Credentials");
//			return "login";
//		}
//		modelMap.put("name", login.getName());
//		return "welcome";
//
//	}

}
