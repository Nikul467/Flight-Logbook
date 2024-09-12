package com.nikul.logbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nikul.logbook.models.Flight;
import com.nikul.logbook.models.FlightDto;
import com.nikul.logbook.services.FlightsRepository;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/flights")

public class FlightsController {
	
	@Autowired
	private FlightsRepository repo;
	
	@GetMapping({"", "/"})
	public String showFlightList(Model model) {
	    List<Flight> flights = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
	    model.addAttribute("flights", flights);
	    return "flights/index";
	}
	
	@GetMapping("/add")
	public String showCreatePage(Model model) {
	    FlightDto flightDto = new FlightDto();
	    model.addAttribute("flightDto", flightDto);
	    return "flights/AddFlight";
	}
	
	@PostMapping("/add")
	public String addFlight(
	@Valid @ModelAttribute FlightDto flightDto,
	BindingResult result
	) {
		
	if(result.hasErrors()) {
		return "flights/AddFlight";
	}
	
	Flight flight = new Flight();
	flight.setDate(flightDto.getDate());
	flight.setAircraft(flightDto.getAircraft());
	flight.setRegistration(flightDto.getRegistration());
	flight.setDepartureICAO(flightDto.getDepartureICAO());
	flight.setArrivalICAO(flightDto.getArrivalICAO());
	flight.setDepartureTime(flightDto.getDepartureTime());
	flight.setArrivalTime(flightDto.getArrivalTime());
	
	repo.save(flight);

	return "redirect:/flights";
	}
	
	@GetMapping("/edit")
	public String showEditPage(
	Model model,
	@RequestParam int id
	) {
		
		try {
			//read flights from database
			Flight flight = repo.findById(id).get();
			model.addAttribute("flight", flight);
			
			FlightDto flightDto = new FlightDto();
			flightDto.setDate(flight.getDate());
			flightDto.setAircraft(flight.getAircraft());
			flightDto.setRegistration(flight.getRegistration());
			flightDto.setDepartureICAO(flight.getDepartureICAO());
			flightDto.setArrivalICAO(flight.getArrivalICAO());
			flightDto.setDepartureTime(flight.getDepartureTime());
			flightDto.setArrivalTime(flight.getArrivalTime());
			
			model.addAttribute("flightDto", flightDto);
			
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
			return "redirect:/flights";

		}
		
	return "flights/EditFlight";
	}
	
	@PostMapping("/edit")
	public String updateProduct(
	Model model,
	@RequestParam int id,
	@Valid @ModelAttribute FlightDto flightDto,
	BindingResult result
	) {
		
		try {
			Flight flight = repo.findById(id).get();
			model.addAttribute("flight", flight);
			
			if(result.hasErrors()){
				return "flights/EditFlight";		
			}
			
			flight.setDate(flightDto.getDate());
			flight.setAircraft(flightDto.getAircraft());
			flight.setRegistration(flightDto.getRegistration());
			flight.setDepartureICAO(flightDto.getDepartureICAO());
			flight.setArrivalICAO(flightDto.getArrivalICAO());
			flight.setDepartureTime(flightDto.getDepartureTime());
			flight.setArrivalTime(flightDto.getArrivalTime());	
			
			repo.save(flight);
			
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
	return "redirect:/flights";
	}
	
	@GetMapping("/delete")
	public String deleteFlight(
	@RequestParam int id
	) {
		
		try {
			Flight flight = repo.findById(id).get();
			
			repo.delete(flight);
		}
		catch(Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
		
	return "redirect:/flights";
	}
	



}
