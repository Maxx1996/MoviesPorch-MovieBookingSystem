package com.movie_booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_booking.entities.Movie;
import com.movie_booking.exception.NotFoundException;
import com.movie_booking.repository.MovieRepository;

@Service
public class MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private ShowService showService;

	public Movie inputMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}

	public Movie getMovieDetails(int id) {
		
		Optional<Movie> selectedMovie = movieRepository.findById(id);
		if(!selectedMovie.isPresent())
			throw new NotFoundException("Movie not found");
		return selectedMovie.get();
	}

	public Iterable<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public MovieRepository getmovieRepository() {
		return movieRepository;
	}

	public void setmovieRepository(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<String> getListOfMovies() {
		return movieRepository.getListOfMovies();
	}

	public Movie removeMovie(int id) {
		Optional<Movie> selectedMovie = movieRepository.findById(id);
		if(!selectedMovie.isPresent())
			throw new NotFoundException("Movie not found");
		boolean isTrue = true;
		if(selectedMovie.get().isStatus() == isTrue) {
			selectedMovie.get().setStatus(false);
		}
		showService.removeAllShows(id);
		return movieRepository.save(selectedMovie.get());
	}

}
