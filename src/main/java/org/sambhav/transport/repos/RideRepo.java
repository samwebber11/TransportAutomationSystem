package org.sambhav.transport.repos;

import org.sambhav.transport.models.Rides;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepo extends JpaRepository<Rides,Integer>{

}
