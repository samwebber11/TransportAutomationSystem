package org.sambhav.transport.services;

import java.util.Arrays;
import java.util.HashSet;

import org.sambhav.transport.models.Role;
import org.sambhav.transport.models.User;
import org.sambhav.transport.repos.RoleRepo;
import org.sambhav.transport.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public User findByEmail(String email)
	{
		return userRepo.findByEmail(email);
	}

	public void saveUser(User user)
	{
		user.setPasswd(bCryptPasswordEncoder.encode(user.getPasswd()));
		Role roles = roleRepo.findByName("USER");
		user.setRoles(new HashSet<>(Arrays.asList(roles)));
		userRepo.save(user);
	}
}
