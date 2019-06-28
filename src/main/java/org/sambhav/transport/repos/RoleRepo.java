package org.sambhav.transport.repos;

import org.sambhav.transport.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer>{
	
	public Role findByName(String name);
}
