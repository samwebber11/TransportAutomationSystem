package org.sambhav.transport.repos;

import org.sambhav.transport.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

	public User findByEmail(String email);
}
