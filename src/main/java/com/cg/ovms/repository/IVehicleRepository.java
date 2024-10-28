package com.cg.ovms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {

	// Vehicle findById(long vehicleId);

	Optional<Vehicle> findById(Long driverId);
	
	 List<Vehicle> findByCategory(String category);
	 
	 List<Vehicle> findByCapacity(Long capacity);
	 
	 
	 
	
}
