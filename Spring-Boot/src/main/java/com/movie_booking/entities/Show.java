package com.movie_booking.entities;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "SHOWS")
public class Show{
	
	@Id
	@SequenceGenerator(name = "my.entity.seq", sequenceName = "EVENT_SEQ", allocationSize = 10, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my.entity.seq")
	private int id;
	private Time startTime;
	private int seatCount;
	private int price;
	private boolean status = true;
	
	@ManyToOne
	@JoinColumn(name = "MOVIE_ID")
	public Movie movie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", startTime=" + startTime + ", seatCount=" + seatCount + ", price=" + price
				+ ", status=" + status + ", movie=" + movie + "]";
	}
	
	
}
