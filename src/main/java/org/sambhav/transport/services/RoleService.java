package org.sambhav.transport.services;

import java.util.ArrayList;
import java.util.List;

import org.sambhav.transport.models.Role;
import org.sambhav.transport.repos.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	public List<Role> findAllRoles()
	{
		List<Role> roles = new ArrayList<>();
		roleRepo.findAll().forEach(roles::add);
		return roles;
	}
}
