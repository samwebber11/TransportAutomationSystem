package org.sambhav.transport.controllers;

import java.util.List;

import org.sambhav.transport.models.TransportDriver;
import org.sambhav.transport.services.TransportDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/driver")
public class DriverController {

	
	@Autowired
	private TransportDriverService service;
	
	@GetMapping("/service")
	public List<TransportDriver> getAllDrivers()
	{
		return service.findAllDrivers();
	}
}
