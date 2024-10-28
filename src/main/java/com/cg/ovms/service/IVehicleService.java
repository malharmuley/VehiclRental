package com.cg.ovms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.repository.IVehicleRepository;

@Service
public class IVehicleService {
	@Autowired
	private IVehicleRepository vehicleRepository;

//To view all Vehicles
	public List<Vehicle> viewAllVehicles() {
		return vehicleRepository.findAll();
	}

// To view Booking By vehiclesId
	public Optional<Vehicle> viewBookingByVehicle(Long vehicleId) {
		// TODO Auto-generated method stub
		return vehicleRepository.findById(vehicleId);
	}

//To add Vehicle
	public Vehicle addVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}
	
	//To search vehicle by category
	
//	public List<Vehicle> searchByCategory(String category) {
//        return vehicleRepository.findByCategory(category);
//    }
	
	 public List<Vehicle> getVehiclesByCategory(String category) {
	        return vehicleRepository.findByCategory(category);
	    }
	 
	 public List<Vehicle> getVehiclesByCapacity(Long capacity) {
	        return vehicleRepository.findByCapacity(capacity);
	    }
	
	

}


