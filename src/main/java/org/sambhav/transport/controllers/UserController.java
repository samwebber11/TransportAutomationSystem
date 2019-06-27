package org.sambhav.transport.controllers;

import java.util.List;

import org.sambhav.transport.models.User;
import org.sambhav.transport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String findAll()
	{
		List<User> users = userService.findAllUsers();
		System.out.println(users);
		return "welcome";
	}
}
