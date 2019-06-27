package org.sambhav.transport.services;

import java.util.ArrayList;
import java.util.List;

import org.sambhav.transport.models.Rides;
import org.sambhav.transport.repos.RideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {

	@Autowired
	private RideRepo rideRepo;
	
	public List<Rides> findAllRides()
	{
		List<Rides> rides = new ArrayList<>();
		rideRepo.findAll().forEach(rides::add);
		return rides;
	}
}
