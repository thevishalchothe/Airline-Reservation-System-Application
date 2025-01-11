package com.airlinereservationsystem.application.serviceI;

import java.util.Date;
import java.util.List;

import com.airlinereservationsystem.application.model.Flight;

public interface FlightServiceI {

	List<Flight> searchFlights(String source, String destination, Date departureDate);

	Flight getFlightById(Long id);

	void updateFlight(Flight flight);

}
