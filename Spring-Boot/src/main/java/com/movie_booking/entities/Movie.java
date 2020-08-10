package com.movie_booking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "MOVIE")
public class Movie{
	@Id
	@SequenceGenerator(name = "my.entity.seq", sequenceName = "EVENT_SEQ", allocationSize = 10, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my.entity.seq")
	private Integer id;
	
	private String movieName;
	private int seats;
	private String language;
	private boolean status = true;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", seats=" + seats + ", language=" + language
				+", status=" + status + "]";
	}

}
