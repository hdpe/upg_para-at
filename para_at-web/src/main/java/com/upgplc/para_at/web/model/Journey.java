package com.upgplc.para_at.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Journey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Taxi taxi;
	
	private int length;

	@SuppressWarnings("unused")
	private Journey() {
		// for JPA
	}
	
	public Journey(Taxi taxi, int length) {
		this.taxi = taxi;
		this.length = length;
	}
	
	public Long getId() {
		return id;
	}
	
	public Taxi getTaxi() {
		return taxi;
	}
	
	public int getLength() {
		return length;
	}
}
