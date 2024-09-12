package com.nikul.logbook.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikul.logbook.models.Flight;

public interface FlightsRepository extends JpaRepository<Flight, Integer> {

}
