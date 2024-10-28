package com.cg.ovms.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AddressDTO {
	@NotEmpty private String city;
	@NotEmpty private String state;
	@NotNull private Long pincode;
	
	public AddressDTO() {}
	
	public AddressDTO(String city, String state, Long pincode) {
		super();
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}


}
