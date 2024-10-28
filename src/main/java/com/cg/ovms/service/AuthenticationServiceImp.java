package com.cg.ovms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.repository.IUserRepository;
@Service
public class AuthenticationServiceImp {
	@Autowired
	
	private IUserRepository userRepository;
	
	public AbstractUser login(String emailaddress,String password) throws Exception {
		System.out.println(emailaddress);
		System.out.println(password);
		AbstractUser optionalUser=userRepository.findByEmailAddress(emailaddress);
		if(optionalUser == null) {
			throw new Exception("User not registered.");
			
		}
		AbstractUser user=optionalUser;
     	if(!password.equals(user.getPassword())) {
			throw new Exception("Login is Failed");
		}
		return user;
}
}