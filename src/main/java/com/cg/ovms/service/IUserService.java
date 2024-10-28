package com.cg.ovms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.entities.Address;
import com.cg.ovms.exceptionhandling.exceptiion.EmptyInputException;
import com.cg.ovms.exceptionhandling.exceptiion.ExistingUserException;
import com.cg.ovms.model.UserDTO;
import com.cg.ovms.repository.IUserRepository;

@Service
public class IUserService {
	@Autowired
	private IUserRepository userRepository;
	


	// Implementation to retrieve all users from database
	public List<AbstractUser> getAllUsers() {
		return userRepository.findAll();
	}
    // To add user 
	public AbstractUser addUser(AbstractUser user) {
		if ((user.getFirstName().isEmpty() || user.getFirstName().length() == 0)
				&& (user.getLastName().isEmpty() || user.getLastName().length() == 0)
				&& (user.getPassword().isEmpty() || user.getPassword().length() == 0)) {
			throw new EmptyInputException();
		}

		return userRepository.save(user);
	}
	
	public String addUser(UserDTO user) {
		List<String> emptyK = new ArrayList<>();
		if(user.getFirstName().isEmpty()) emptyK.add("firstName");
		if(user.getUserType().isEmpty()) emptyK.add("userType");
		if(user.getLastName().isEmpty()) emptyK.add("lastName");
		if(user.getPassword().isEmpty()) emptyK.add("password");
		if(user.getEmailAddress().isEmpty()) emptyK.add("emailAddress");
		if(user.getAddress().getCity().isEmpty()) emptyK.add("address city");
		if(user.getAddress().getState().isEmpty()) emptyK.add("address state");
		if(user.getAddress().getPincode() == null) emptyK.add("address pincode");
		
		if(emptyK.size() > 0)
		{
			String res1 = "";
			res1= (emptyK.size()>1) ? "Input fields " : "Input field ";
			for(int i=0; i<emptyK.size(); i++) {
				res1 = (emptyK.size()-i>1) ? res1.concat(emptyK.get(i))+" and " : res1.concat(emptyK.get(i));
			}
			res1= (emptyK.size()>1) ? res1.concat(" are empty.") : res1.concat(" is empty.");
			throw new EmptyInputException(res1, res1);
		}
		
		AbstractUser newUser = new AbstractUser();
		
		AbstractUser existingUserByEmail = userRepository.findByEmailAddress(user.getEmailAddress());

		if(existingUserByEmail != null) {
			throw new ExistingUserException("Cannot add new "+ user.getUserType()+" "+user.getFirstName()+
					". User with such email address already exists. \nChange your email.");
		}
		
		newUser.setUserType(user.getUserType());
		newUser.setPassword(user.getPassword());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setEmailAddress(user.getEmailAddress());
		
		Address userAddress = new Address();
		userAddress.setCity(user.getAddress().getCity());
		userAddress.setState(user.getAddress().getState());
		userAddress.setPincode(user.getAddress().getPincode());
		
		newUser.setAddress(userAddress);
		
		AbstractUser savedUser = userRepository.save(newUser);
		
		String str1 = "New "+savedUser.getUserType().toString()+" "+savedUser.getFirstName()+
				" "+savedUser.getLastName()+" successfully added.";
		return str1;
	}
	
	//to update user
	public AbstractUser updateUser(AbstractUser user) {
		AbstractUser user1=userRepository.findById(user.getId());
		if(user1==null) {
			throw new EmptyInputException();
		}
		if ((user.getFirstName().isEmpty() || user.getFirstName().length() == 0)
				&& (user.getLastName().isEmpty() || user.getLastName().length() == 0)
				&& (user.getPassword().isEmpty() || user.getPassword().length() == 0)) {
			throw new EmptyInputException();
		}

		return userRepository.save(user);
	}

	// Implementation to retrieve address by the addressId from the database
	public AbstractUser getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

}
