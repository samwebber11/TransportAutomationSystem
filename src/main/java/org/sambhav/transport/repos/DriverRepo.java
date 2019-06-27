package org.sambhav.transport.repos;

import org.sambhav.transport.models.TransportDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<TransportDriver,Integer>{

}
