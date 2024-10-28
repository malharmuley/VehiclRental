package com.cg.ovms.service;

import com.cg.ovms.entities.AbstractUser;

public interface AuthenticationService {
 public  AbstractUser login(String emailaddress,String password);
}