package com.cg.ovms.ControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.model.AddressDTO;
import com.cg.ovms.model.UserDTO;
import com.cg.ovms.rest.UserController;
import com.cg.ovms.service.IUserService;

public class UserControllerTest {
	@ExtendWith(MockitoExtension.class)

	@Mock
	private IUserService userService;
	@InjectMocks
	private UserController userController;

	@Test
	public void testAddUser() {
//		AbstractUser a1 = new AbstractUser();
//		a1.setId(1);
//		a1.setFirstName("perk");
//		a1.setLastName("cal");
//		a1.setEmailAddress("perk@testmail.com");
//		a1.setPassword("perk456");
//		a1.setUserType("customer");
		AddressDTO  adress = new AddressDTO("New York", "NY", 1212L);
		UserDTO a1 = new UserDTO("USER", "testPASS01", "testName01", "testLastName01", "testEmail@gmail.com", adress);

		when(userService.addUser(a1)).thenReturn("User Saved");
		ResponseEntity<String> actualResponse = userController.addUser(a1);

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("User Saved", actualResponse.getBody());
	}
			
			@Test
			public void getUsersTest() {
				when(userService.getAllUsers()).thenReturn(Stream
						.of(new AbstractUser()).collect(Collectors.toList()));
				assertEquals(1, userService.getAllUsers().size());
			}
			


	
	

}
