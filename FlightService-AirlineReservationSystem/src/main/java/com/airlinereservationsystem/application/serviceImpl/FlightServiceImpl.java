package com.airlinereservationsystem.application.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.airlinereservationsystem.application.model.Flight;
import com.airlinereservationsystem.application.repository.FlightRepository;
import com.airlinereservationsystem.application.serviceI.FlightServiceI;

@Service
public class FlightServiceImpl implements FlightServiceI {

	private static final Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

	private FlightRepository flightRepository;

	@Override
	public List<Flight> searchFlights(String source, String destination, Date departureDate) {
		logger.info("Searching for flights from {} to {} on {}", source, destination, departureDate);
		return flightRepository.findBySourceAndDestinationAndDepartureTimeAfter(source, destination, departureDate);
	}

	@Override
	public Flight getFlightById(Long id) {
		logger.info("Fetching flight with ID {}", id);
		return flightRepository.findById(id).orElseThrow(() -> {
			logger.error("Flight with ID {} not found", id);
			return new RuntimeException("Flight not found");
		});
	}

	@Override
	public void updateFlight(Flight flight) {
		logger.info("Updating flight with ID {}", flight.getFlightId());
		flightRepository.save(flight);
	}
}
