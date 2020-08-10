package com.movie_booking.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_booking.entities.User;
import com.movie_booking.exception.NotFoundException;
import com.movie_booking.repository.UserRepository;

@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	

	public User inputUser(User user){
		return userRepository.save(user);
	}
	

	public User getUserDetails(int id){
		Optional<User> selectedUser = userRepository.findById(id);
		if(!selectedUser.isPresent())
			throw new NotFoundException("User not found");
		return selectedUser.get();
	}
	

	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}

	public UserRepository getuserRepository() {
		return userRepository;
	}

	public void setuserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
