package com.movie_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie_booking.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Query(value = "from User")
	List<User> getAllUsers();
}
