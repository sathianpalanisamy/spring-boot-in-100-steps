package com.learning.springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogOutController {

	@RequestMapping(method = RequestMethod.GET, path = "/logout")
	public String logOut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.isAuthenticated()) {
			new SecurityContextLogoutHandler().logout(httpServletRequest, httpServletResponse, authentication);

		}
		return "redirect:/";
	}

}
