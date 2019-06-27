package org.sambhav.transport.controllers;

import java.util.List;

import org.sambhav.transport.models.Role;
import org.sambhav.transport.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class SecurityController {

	@Autowired
	private RoleService service;
	
	@GetMapping("/service")
	public List<Role> findAllRoles()
	{
		return service.findAllRoles();
	}
}
