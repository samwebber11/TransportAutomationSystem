package org.sambhav.transport.services;

import java.util.ArrayList;
import java.util.List;

import org.sambhav.transport.models.User;
import org.sambhav.transport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	private UserRepo userRepo;
	
	
	public List<User> findAllUsers() {
		List<User> list = new ArrayList<>();
		userRepo.findAll().forEach(list::add);
		return list;
	}

}
