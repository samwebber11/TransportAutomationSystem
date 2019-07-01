package org.sambhav.transport.controllers;

import org.sambhav.transport.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RideController {

	
	@Autowired
	private RideService service;
		
}
