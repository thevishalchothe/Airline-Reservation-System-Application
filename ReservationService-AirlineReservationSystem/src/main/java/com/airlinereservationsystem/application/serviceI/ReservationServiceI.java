package com.airlinereservationsystem.application.serviceI;

import java.util.List;

import com.airlinereservationsystem.application.model.Reservation;

public interface ReservationServiceI {

	Reservation bookTicket(Long flightId, String passengerName, String email, int numberOfSeats);

	Reservation cancelTicket(Long reservationId);

	List<Reservation> getReservationsByFlight(Long flightId);

}
