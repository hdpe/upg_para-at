package com.upgplc.para_at.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Taxi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Company company;
	
	private String registration;

	@SuppressWarnings("unused")
	private Taxi() {
		// for JPA
	}
	
	public Taxi(Company company, String registration) {
		this.company = company;
		this.registration = registration;
	}
	
	public Long getId() {
		return id;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public String getRegistration() {
		return registration;
	}
}
