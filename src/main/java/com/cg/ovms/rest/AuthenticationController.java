package com.cg.ovms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.service.AuthenticationServiceImp;
import com.gc.ovms.dto.LoginReq;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationServiceImp authenticationService;

	@PostMapping("/login")
	public ResponseEntity<AbstractUser> doLogin(@RequestBody LoginReq loginReq) throws Exception {
		AbstractUser user = authenticationService.login(loginReq.getEmailaddress(), loginReq.getPassword());
		ResponseEntity<AbstractUser> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}
}