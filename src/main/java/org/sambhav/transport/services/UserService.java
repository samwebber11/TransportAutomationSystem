package org.sambhav.transport.services;

import org.sambhav.transport.models.User;
import org.sambhav.transport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	private UserRepo userRepo;
	
	
	public User findByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}

	public void saveUser(User user)
	{
		userRepo.save(user);
	}
}
