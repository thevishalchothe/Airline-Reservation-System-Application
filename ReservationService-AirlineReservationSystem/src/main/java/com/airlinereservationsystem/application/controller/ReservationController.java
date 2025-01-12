package com.airlinereservationsystem.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlinereservationsystem.application.model.Reservation;
import com.airlinereservationsystem.application.serviceI.ReservationServiceI;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

	@Autowired
	private ReservationServiceI reservationServiceI;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@PostMapping("/book")
	public ResponseEntity<Reservation> bookTicket(@RequestParam Long flightId, @RequestParam String passengerName,
			@RequestParam String email, @RequestParam int numberOfSeats) {
		logger.info("Request to book ticket: flightId={}, passengerName={}, email={}, numberOfSeats={}", flightId,
				passengerName, email, numberOfSeats);
		Reservation reservation = reservationServiceI.bookTicket(flightId, passengerName, email, numberOfSeats);
		logger.info("Ticket booked successfully: {}", reservation);
		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}

	@PostMapping("/cancel")
	public ResponseEntity<Reservation> cancelTicket(@RequestParam Long reservationId) {
		logger.info("Request to cancel ticket: reservationId={}", reservationId);
		Reservation reservation = reservationServiceI.cancelTicket(reservationId);
		logger.info("Ticket canceled successfully: {}", reservation);
		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}

	@GetMapping("/flight/{flightId}")
	public ResponseEntity<List<Reservation>> getReservationsByFlight(@PathVariable Long flightId) {
		logger.info("Fetching reservations for flightId={}", flightId);
		List<Reservation> reservations = reservationServiceI.getReservationsByFlight(flightId);
		logger.info("Reservations fetched: {}", reservations);
		return new ResponseEntity<>(reservations, HttpStatus.OK);
	}
}
