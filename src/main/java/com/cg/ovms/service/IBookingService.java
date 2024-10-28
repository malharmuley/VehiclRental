package com.cg.ovms.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.ovms.entities.AbstractUser;
import com.cg.ovms.entities.Booking;
import com.cg.ovms.entities.Vehicle;
import com.cg.ovms.model.BookingResponseDTO;
import com.cg.ovms.model.BookingUserDTO;
import com.cg.ovms.model.BookingVehicleDTO;
import com.cg.ovms.repository.IBookingRepository;
import com.cg.ovms.repository.IUserRepository;
import com.cg.ovms.repository.IVehicleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IBookingService {
	@Autowired
	private IBookingRepository bookingRepository;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IVehicleRepository vehicleRepository;

	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	// to retrieve all bookings by Id
	@Transactional(readOnly = true)
	public BookingResponseDTO getBookingsById(Integer bookingId) {
		// gets booking entity domain model of bookingId
		Booking bookingDM = bookingRepository.findById(bookingId).orElse(null);
		
		BookingResponseDTO booking = new BookingResponseDTO();
		
		BookingUserDTO userDTO = new BookingUserDTO(
				bookingDM.getUser().getId(),
				bookingDM.getUser().getFirstName(),
				bookingDM.getUser().getLastName(),
				bookingDM.getUser().getEmailAddress(),
				bookingDM.getUser().getUserType(),
				bookingDM.getUser().getAddress()
				);
		BookingVehicleDTO vehicleDTO = new BookingVehicleDTO(
				bookingDM.getVehicle().getVehicleId(),
				bookingDM.getVehicle().getVehicleNumber(),
				bookingDM.getVehicle().getType(),
				bookingDM.getVehicle().getCategory(),
				bookingDM.getVehicle().getDescription(),
				bookingDM.getVehicle().getCapacity(),
				bookingDM.getVehicle().getChargesPerDay()
				);
		
		booking.setBookingId(bookingDM.getBookingId());
		booking.setBookingDate(bookingDM.getBookingDate().toInstant().atZone(ZoneId.of("UTC+05:30")).toOffsetDateTime());
		booking.setBookingFromDate(bookingDM.getBookingFromDate().toInstant().atZone(ZoneId.of("UTC+05:30")).toOffsetDateTime());
		booking.setBookingTillDate(bookingDM.getBookingTillDate().toInstant().atZone(ZoneId.of("UTC+05:30")).toOffsetDateTime());
		booking.setBookingDescription(bookingDM.getBookingDescription());
		booking.setBookingStatus(bookingDM.getBookingStatus());
		booking.setTotalCost(bookingDM.getTotalCost());
		booking.setDistance(bookingDM.getDistance());
		booking.setPayment(bookingDM.getPayment());
		booking.setUserInfo(userDTO);
		booking.setVehicleInfo(vehicleDTO);
		
		return booking;
	}


	// To add booking
	 @Transactional
	 
		public ResponseEntity<String> addBooking(Booking booking) {
		 booking.setBookingDate(new Date());
		 	
			AbstractUser user = userRepository.findById(booking.getUser().getId());
			
			if(user == null) {
				String str2 = "No such user with id: "+booking.getUser().getId()+" so the vehicle cannot be rent";
				return new ResponseEntity<String>(str2, HttpStatus.NOT_FOUND);
			}
			
			Vehicle vehicle = vehicleRepository.findById((long) booking.getVehicle().getVehicleId()).orElse(null);
			
			if(vehicle == null) {
				String str3 = "No such vehicle available with id: "+booking.getVehicle().getVehicleId()+
						"Provide existing vehicle with existing ID.";
				return new ResponseEntity<String>(str3, HttpStatus.NOT_FOUND);
			}
			
			List<Booking> bookingsList = bookingRepository.findAll();
			
			for(Booking thisBooking : bookingsList) {
				
				if( thisBooking.getVehicle().getVehicleId() == booking.getVehicle().getVehicleId() ) {
					
					if(((booking.getBookingFromDate().before(thisBooking.getBookingTillDate()) &&
					     booking.getBookingFromDate().after(thisBooking.getBookingFromDate())) ||
					    (booking.getBookingTillDate().before(thisBooking.getBookingTillDate()) &&
						 booking.getBookingTillDate().after(thisBooking.getBookingFromDate()))) 
						||
						(
						 booking.getBookingFromDate().equals(thisBooking.getBookingFromDate()) &&
						 booking.getBookingTillDate().equals(thisBooking.getBookingTillDate())
						)
						 
					   ) {
						String str1 = "You cannot order the car with id: "+booking.getVehicle().getVehicleId()+
								" because it is already rent by the user with ID: "+thisBooking.getUser().getId()+" - "+
								thisBooking.getUser().getFirstName()+ " "+
								thisBooking.getUser().getLastName();
						return new ResponseEntity<String>(str1, HttpStatus.CONFLICT);
					}
				}
			}
			
			if(booking.getBookingDate().after(booking.getBookingTillDate()) ||
			   booking.getBookingDate().after(booking.getBookingFromDate())) {
				String str6 = "Your booking time is later than your vehicle booking till or from time.\n"
						+"Request rejected. Write dates correctly.";
				return new ResponseEntity<String>(str6, HttpStatus.NOT_ACCEPTABLE);
			}
			else if(booking.getBookingFromDate().after(booking.getBookingTillDate())) {
				String str4 = "Your vehicle booking TILL time is earlier than your vehicle booking FROM time.\n"
						+"Request rejected. Write dates correctly.";
				return new ResponseEntity<String>(str4, HttpStatus.NOT_ACCEPTABLE);
			}
			
			Calendar c1 = Calendar.getInstance();
			Date cDate = c1.getTime();
			SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd - HH:mm:ss");
			
			String str0_1 = "";
			String str0_2 = "";
			String str0_3 = "";
			
//			if(booking.getBookingDate().before(cDate)) {
//				str0_1 = "booking date you entered: "+mdyFormat.format(booking.getBookingDate());
//			}
			if(booking.getBookingFromDate().before(cDate)) {
				str0_2 = "booking FROM date you entered: "+mdyFormat.format(booking.getBookingFromDate());
				if(str0_1.length() > 0)
				str0_2 = "\nand "+str0_2;
			}
			if(booking.getBookingTillDate().before(cDate)) {
				str0_3 = "booking TILL date you entered: "+mdyFormat.format(booking.getBookingTillDate());
				if(str0_1.length() > 0 || str0_2.length() > 0)
				str0_3 = "\nand "+str0_3;
			}
			
			String str0_0 = str0_1+str0_2+str0_3;
			
			String str0 = "";
			
//			if(str0_0.length()>0) {
//				str0 = "\nBe warned that the "+str0_0+
//						" is in the past. Current date and time is: "+mdyFormat.format(cDate)+
//						". \nIn real application you would have to specify vehicle booking dates at a certain time in future from the current date.";
//			}
			
			user.setVehicle(vehicle);
			
			userRepository.save(user);
	
			bookingRepository.save(booking);
			
			String str5 = "The car successfully rented to you."+str0;
			
			return new ResponseEntity<String>(str5, HttpStatus.CREATED);
		}
	// To add booking by user Id
	/*@Transactional
	public Booking addBooking(Booking booking, Long id) {
		Optional<AbstractUser> user = userRepository.findById(id);

		if (user.get().getBookings().size() > 0) {
			user.get().getBookings().add(booking);
		} else {
			List<Booking> bookingList = new ArrayList<Booking>();
			bookingList.add(booking);
			user.get().setBookings(bookingList);
		}

		userRepository.save(user.get());
		booking.setUser(user.get());

		return bookingRepository.save(booking);
	}*/

	// To cancel booking
	public void cancelBookingById(Integer bookingId) {
		bookingRepository.deleteById(bookingId);
	}

	// To view list of bookings by bookingId
	public Optional<Booking> viewBooking(Integer bookingId) {
		return bookingRepository.findById(bookingId);
	}

	// To view list of bookings by vehicleNumber
	public Optional<Booking> viewBookingByVehicle(Integer vehicleId) {
		// TODO Auto-generated method stub
		return bookingRepository.findById(vehicleId);
	}
	
	 public List<Booking> getAllBookingsByUserId(Long userId) {
	        return bookingRepository.findByUserId(userId);
	    }
}