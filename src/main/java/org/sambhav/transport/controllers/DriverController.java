package org.sambhav.transport.controllers;

import java.util.List;

import org.sambhav.transport.models.TransportDriver;
import org.sambhav.transport.services.TransportDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/driver")
public class DriverController {

	
	@Autowired
	private TransportDriverService service;
	
	@GetMapping("/login")
	public ModelAndView transportLogin()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("driverLogin");
		return view;
	}
}
