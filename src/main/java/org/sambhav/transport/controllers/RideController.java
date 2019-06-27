package org.sambhav.transport.controllers;

import java.util.List;

import org.sambhav.transport.models.Rides;
import org.sambhav.transport.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideController {

	
	@Autowired
	private RideService service;
	
	@GetMapping("/rides")
	public List<Rides> findAllRides()
	{
		List<Rides> rides  = service.findAllRides();
		return rides;
	}
}
