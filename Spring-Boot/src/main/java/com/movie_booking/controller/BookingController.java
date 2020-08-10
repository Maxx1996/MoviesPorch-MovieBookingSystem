package com.movie_booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie_booking.entities.Booking;
import com.movie_booking.service.BookingService;

@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;
	
	@GetMapping(path = "/api/booking/{id}")
	@ResponseBody
	public Booking getBooking(@PathVariable int id) {
		return bookingService.getBookingDetails(id);
	}
	
	@PostMapping(path = "/api/booking/{showId}/{userId}/")
	@ResponseBody
	public Booking saveBooking(@RequestBody Booking booking, @PathVariable int showId, @PathVariable int userId) {
		return bookingService.saveBooking(booking, showId, userId);
	}
	
	@DeleteMapping(path = "/api/booking/{id}")
	@ResponseBody
	public Booking cancelMovieBooking(@PathVariable int id) {
		return bookingService.cancelMovieBooking(id);
	}
	
	@GetMapping(path = "api/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<Booking> getBookings(){
		return bookingService.getAllBookings();
	}
	
	@GetMapping(path = "api/bookings/status", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Booking> getActiveBookings(){
		return bookingService.getActiveBookings();
	}
	
	@GetMapping(value = "/api/bookings/{userId}")
	@ResponseBody
	public List<Booking> getUserActiveBookings(@PathVariable int userId){
		return bookingService.getUserActiveBookings(userId);
	}
}
