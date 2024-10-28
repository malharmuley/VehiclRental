package com.cg.ovms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.ovms.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByUserId(Long userId);

	//Optional<Booking> findById(Long bookingId);

}
