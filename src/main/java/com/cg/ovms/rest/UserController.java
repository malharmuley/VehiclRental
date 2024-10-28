package com.cg.ovms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.model.UserDTO;
import com.cg.ovms.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/getAllUser")
	public List<AbstractUser> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public AbstractUser getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	/*
	 * @PostMapping public AbstractUser addUser(@RequestBody AbstractUser user) {
	 * return userService.addUser(user); }
	 */

	@PostMapping("/addUsers")
	public ResponseEntity<String> addUser(@RequestBody UserDTO user) {
		userService.addUser(user);
		return ResponseEntity.ok("User Saved");
	}

	@PutMapping("/updateUser")
	public AbstractUser updateUser(@RequestBody AbstractUser user) {
		return userService.updateUser(user);
	}

	
}