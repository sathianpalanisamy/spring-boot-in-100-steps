package com.learning.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateCredentials(String name, String pass) {

		return name.equals("sathian") && pass.equals("pass");

	}

}
