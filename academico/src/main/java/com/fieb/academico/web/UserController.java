package com.fieb.academico.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fieb.academico.service.UserService;
import com.fieb.academico.web.dto.UserDto;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "registration";
	}
	
	public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
		userService.save(userDto);
		return "redirect:/registration?success";
	}
}
