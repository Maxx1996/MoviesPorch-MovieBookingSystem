package com.movie_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie_booking.entities.Booking;
@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
	@Query(value = "from Booking")
	List<Booking> getAllBookings();
	@Query(value = "from Booking where status = true")
	List<Booking> getActiveBookings();
	@Query(value = "from Booking booking where (booking.status = true AND booking.user.id = ?1)")
	List<Booking> getUserActiveBookings(int userId);
}
