package com.movie_booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_booking.entities.Booking;
import com.movie_booking.entities.Show;
import com.movie_booking.entities.User;
import com.movie_booking.exception.NotFoundException;
import com.movie_booking.repository.BookingRepository;
import com.movie_booking.repository.ShowRepository;
import com.movie_booking.repository.UserRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private ShowRepository showRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookingService service;
	@Autowired
	private ShowService showService;

	public Booking inputBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Booking getBookingDetails(int id) {
		Optional<Booking> selectedBooking = bookingRepository.findById(id);
		if (!selectedBooking.isPresent())
			throw new NotFoundException("Booking not found");
		return selectedBooking.get();
	}

	public Iterable<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking saveBooking(Booking booking, int showId, int userId) {
		Optional<Show> selectedShow = showRepository.findById(showId);
		if (!selectedShow.isPresent())
			throw new NotFoundException("Show not found");
		Optional<User> selectedUser = userRepository.findById(userId);
		if (!selectedUser.isPresent())
			throw new NotFoundException("User not found");
		int price = selectedShow.get().getPrice();
		booking.setShow(selectedShow.get());
		booking.setUser(selectedUser.get());
		int seatBooked = booking.getSeats();
		booking.setAmountPaid(price * seatBooked);
		showService.seatBooked(seatBooked, showId);
		return service.inputBooking(booking);
	}

	public Booking cancelMovieBooking(int id) {
		Optional<Booking> selectedBooking = bookingRepository.findById(id);
		if (!selectedBooking.isPresent())
			throw new NotFoundException("Booking not found");
		boolean isTrue = true;
		if (selectedBooking.get().isStatus() == isTrue) {
			selectedBooking.get().setStatus(false);
			Show selectedShow = selectedBooking.get().getShow();
			int seatReleased = selectedBooking.get().getSeats();
			int showId = selectedShow.getId();
			showService.seatReleased(seatReleased, showId);
			return bookingRepository.save(selectedBooking.get());
		}
		return bookingRepository.save(selectedBooking.get());
	}

	public List<Booking> getActiveBookings() {
		return bookingRepository.getActiveBookings();
	}

	public List<Booking> getUserActiveBookings(int userId) {
		return bookingRepository.getUserActiveBookings(userId);
	}

}
