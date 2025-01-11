package com.airlinereservationsystem.application.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlinereservationsystem.application.model.Flight;
import com.airlinereservationsystem.application.serviceI.FlightServiceI;

@RestController
@RequestMapping("/flights")
public class FlightController {

	private FlightServiceI flightServiceI;

	@GetMapping("/search")
	public ResponseEntity<List<Flight>> searchFlights(@RequestParam String source, @RequestParam String destination,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date departureDate) {
		List<Flight> flights = flightServiceI.searchFlights(source, destination, departureDate);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
		Flight flight = flightServiceI.getFlightById(id);
		return new ResponseEntity<>(flight, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Void> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
		flight.setFlightId(id);
		flightServiceI.updateFlight(flight);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
