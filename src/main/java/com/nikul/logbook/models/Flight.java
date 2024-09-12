package com.nikul.logbook.models;



import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "flights")

public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	private String aircraft;
	private String registration;
	private String departureICAO;
	private String arrivalICAO;
	private LocalTime departureTime;
	private LocalTime arrivalTime;

	@Column(columnDefinition = "TEXT")
	private LocalDate date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getDepartureICAO() {
		return departureICAO;
	}

	public void setDepartureICAO(String departureICAO) {
		this.departureICAO = departureICAO;
	}

	public String getArrivalICAO() {
		return arrivalICAO;
	}

	public void setArrivalICAO(String arrivalICAO) {
		this.arrivalICAO = arrivalICAO;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	


}
