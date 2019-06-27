package org.sambhav.transport.repos;

import org.sambhav.transport.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {

	public User findByEmail(String email);
}
