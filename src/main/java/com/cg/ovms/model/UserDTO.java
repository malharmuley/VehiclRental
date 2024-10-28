package com.cg.ovms.model;

import jakarta.validation.constraints.NotEmpty;

public class UserDTO {
	@NotEmpty(message = "Name cannot be empty") private String userType;
	@NotEmpty(message = "Password cannot be empty") private String password;
	@NotEmpty(message = "First name cannot be empty") private String firstName;
	@NotEmpty(message = "Last name cannot be empty") private String lastName;
	@NotEmpty(message = "Email address cannot be empty") private String emailAddress;
	private AddressDTO address;
	
	public UserDTO() {}

	public UserDTO(@NotEmpty(message = "Name cannot be empty") String userType,
			@NotEmpty(message = "Password cannot be empty") String password,
			@NotEmpty(message = "First name cannot be empty") String firstName,
			@NotEmpty(message = "Last name cannot be empty") String lastName,
			@NotEmpty(message = "Email address cannot be empty") String emailAddress, AddressDTO address) {
		super();
		this.userType = userType;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.address = address;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	
	
	
	
	
	
	

}
