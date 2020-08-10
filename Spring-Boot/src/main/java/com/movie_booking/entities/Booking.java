package com.movie_booking.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKING")
public class Booking {
	@Id
	@SequenceGenerator(name = "my.entity.seq", sequenceName = "EVENT_SEQ", allocationSize = 10, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my.entity.seq")
	private Integer id;
	
	private Date date;
	private int seats;
	private boolean status = true;
	private int amountPaid = 0;

	@ManyToOne
	@JoinColumn(name = "SHOWS_ID")
	public Show show;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User user;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", date=" + date + ", seats=" + seats + ", status=" + status + ", amountPaid="
				+ amountPaid + ", show=" + show + ", user=" + user + "]";
	}

}
