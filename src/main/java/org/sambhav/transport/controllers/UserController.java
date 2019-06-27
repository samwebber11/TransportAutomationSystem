package org.sambhav.transport.controllers;

import javax.validation.Valid;

import org.sambhav.transport.models.User;
import org.sambhav.transport.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ModelAndView welcome()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("welcome");
		return view;
	}
	
	@GetMapping("/login")
	public ModelAndView login()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}
	
	@GetMapping("/registration")
	public ModelAndView registration()
	{
		ModelAndView view = new ModelAndView();
		User user = new User();
		view.addObject("user",user);
		view.setViewName("registration");
		return view;
	}
	
	@PostMapping("/registration")
	public ModelAndView saveUser(@Valid User user,BindingResult bindingResult)
	{
		 ModelAndView modelAndView = new ModelAndView();
	        User userExists = userService.findByEmail(user.getEmail());
	        if (userExists != null) {
	            bindingResult
	                    .rejectValue("email", "error.user",
	                            "You are already a member.Please kindly login!");
	        }
	        if (bindingResult.hasErrors()) {
	            modelAndView.setViewName("welcome");
	        } else {
	            userService.saveUser(userExists);
	            modelAndView.addObject("successMessage", "User has been registered successfully");
	            modelAndView.addObject("user", new User());
	            modelAndView.setViewName("registration");

	        }
	        return modelAndView;
	}
}
