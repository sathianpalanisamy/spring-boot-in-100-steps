package com.learning.springboot.web.springbootfirstwebapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", ex.getStackTrace());
		modelAndView.addObject("url", request.getRequestURL());
		modelAndView.setViewName("error");
		return modelAndView;
	}

}
