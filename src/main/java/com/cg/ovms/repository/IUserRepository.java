package com.cg.ovms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ovms.entities.AbstractUser;

public interface IUserRepository extends JpaRepository<AbstractUser, Long> {

	AbstractUser findById(Integer id);

	AbstractUser findByEmailAddress(String emailaddress);

//	AbstractUser findByType(String userType);
	
	
	
	
	
	

}
