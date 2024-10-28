package com.cg.ovms.rest;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.model.BookingResponseDTO;
import com.cg.ovms.service.IBookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private IBookingService bookingService;

	@GetMapping("/getBooking")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
	}

	@GetMapping("/BookingById/{bookingId}")
	public BookingResponseDTO getBookingById(@PathVariable Integer bookingId) {
		return bookingService.getBookingsById(bookingId);
	}
	
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
		
	}

	@DeleteMapping("/DeleteBookingById/{bookingId}")
	public void deleteBooking(@PathVariable Integer bookingId) {
		bookingService.cancelBookingById(bookingId);

	}
	
	@GetMapping("/GetBookingByUser/{userId}")
	    public List<Booking> getAllBookingsByUserId(@PathVariable Long userId) {
	        return bookingService.getAllBookingsByUserId(userId);
	    }

}

