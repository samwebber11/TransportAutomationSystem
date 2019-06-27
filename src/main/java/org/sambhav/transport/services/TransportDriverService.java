package org.sambhav.transport.services;

import java.util.ArrayList;
import java.util.List;

import org.sambhav.transport.models.TransportDriver;
import org.sambhav.transport.repos.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportDriverService {

	@Autowired
	private DriverRepo driverRepo;
	
	public List<TransportDriver> findAllDrivers()
	{
		List<TransportDriver> list = new ArrayList<>();
		driverRepo.findAll().forEach(list::add);
		return list;
	}
}
