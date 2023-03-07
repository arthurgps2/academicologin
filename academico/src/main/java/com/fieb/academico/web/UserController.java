package com.fieb.academico.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fieb.academico.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
}
