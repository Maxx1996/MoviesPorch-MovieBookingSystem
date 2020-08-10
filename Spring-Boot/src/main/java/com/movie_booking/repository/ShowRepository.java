package com.movie_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movie_booking.entities.Show;

public interface ShowRepository extends CrudRepository<Show, Integer> {

	@Query(value = "from Show")
	List<Show> getAllShows();
	
	@Query(value = "from Show where movie_id = ?1")
	List<Show> getListOfMovieShows(int movieId);

}
