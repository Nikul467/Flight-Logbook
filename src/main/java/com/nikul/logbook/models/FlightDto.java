package com.nikul.logbook.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class FlightDto {
	

	@NotNull(message = "The date is required")
	private LocalDate date;
	
	@NotEmpty(message = "The aircraft is required")
	private String aircraft;
	
	@NotEmpty(message = "The registration is required")
	private String registration;
	
	@NotEmpty(message = "The departure ICAO is required")
	private String departureICAO;
	
	@NotEmpty(message = "The arrival ICAO is required")
	private String arrivalICAO;
	
	@NotNull(message = "The departure time is required")
	private LocalTime departureTime;
	
	@NotNull(message = "The arrival time is required")
	private LocalTime arrivalTime;




	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public String getArrivalICAO() {
		return arrivalICAO;
	}

	public void setArrivalICAO(String arrivalICAO) {
		this.arrivalICAO = arrivalICAO;
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

	public String getDepartureICAO() {
		return departureICAO;
	}

	public void setDepartureICAO(String departureICAO) {
		this.departureICAO = departureICAO;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

}
