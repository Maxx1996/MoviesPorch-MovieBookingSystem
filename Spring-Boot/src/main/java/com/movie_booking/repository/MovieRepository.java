package com.movie_booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie_booking.entities.Movie;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
	
	@Query(value = "from Movie")
	List<Movie> getAllMovies();
	
	@Query(value = "select movieName from Movie")
	List<String> getListOfMovies();
}
