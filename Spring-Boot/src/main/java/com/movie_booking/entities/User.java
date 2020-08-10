package com.movie_booking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {
	@Id
	@SequenceGenerator(name = "my.entity.seq", sequenceName = "EVENT_SEQ", allocationSize = 10, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my.entity.seq")
	private int id;
	private String name;
	private long mobileNo;

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + "]";
	}

}
