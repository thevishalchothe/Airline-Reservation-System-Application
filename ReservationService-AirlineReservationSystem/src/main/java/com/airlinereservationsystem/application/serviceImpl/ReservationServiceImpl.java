package com.airlinereservationsystem.application.serviceImpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.airlinereservationsystem.application.dto.Flight;
import com.airlinereservationsystem.application.emailutility.EmailService;
import com.airlinereservationsystem.application.model.Reservation;
import com.airlinereservationsystem.application.repository.ReservationRepository;
import com.airlinereservationsystem.application.serviceI.ReservationServiceI;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationServiceI {

    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmailService emailService; // Autowire EmailService

    @Value("${flight.service.url}")
    private String flightServiceUrl;

    @Override
    @Transactional
    public Reservation bookTicket(Long flightId, String passengerName, String email, int numberOfSeats) {
        logger.info("Booking ticket: flightId={}, passengerName={}, email={}, numberOfSeats={}", 
                    flightId, passengerName, email, numberOfSeats);

        String flightEndpoint = flightServiceUrl + "/" + flightId;

        // Fetch flight details
        Flight flight = restTemplate.getForObject(flightEndpoint, Flight.class);

        if (flight == null || flight.getAvailableSeats() < numberOfSeats) {
            logger.error("Booking failed: Not enough seats or flight not found. FlightId={}", flightId);
            throw new RuntimeException("Not enough seats available or flight not found");
        }

        // Deduct seats and update flight
        flight.setAvailableSeats(flight.getAvailableSeats() - numberOfSeats);
        restTemplate.put(flightEndpoint, flight);

        // Save reservation
        Reservation reservation = new Reservation(null, flightId, passengerName, email, numberOfSeats, new Date(), "BOOKED");
        reservation = reservationRepository.save(reservation);

        // Send booking confirmation email via EmailService
        emailService.sendBookingConfirmation(email, reservation);

        logger.info("Reservation successfully made: {}", reservation);
        return reservation;
    }

    @Override
    @Transactional
    public Reservation cancelTicket(Long reservationId) {
        logger.info("Cancelling ticket: reservationId={}", reservationId);

        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if (!"BOOKED".equals(reservation.getStatus())) {
            logger.warn("Cancellation failed: Reservation is already cancelled. ReservationId={}", reservationId);
            throw new RuntimeException("Reservation is already cancelled");
        }

        // Update reservation status
        reservation.setStatus("CANCELLED");
        reservationRepository.save(reservation);

        // Update flight availability
        String flightEndpoint = flightServiceUrl + "/" + reservation.getFlightId();
        Flight flight = restTemplate.getForObject(flightEndpoint, Flight.class);

        if (flight != null) {
            flight.setAvailableSeats(flight.getAvailableSeats() + reservation.getNumberOfSeats());
            restTemplate.put(flightEndpoint, flight);
        }

        // Send cancellation confirmation email via EmailService
        emailService.sendCancellationConfirmation(reservation.getEmail(), reservation);

        logger.info("Reservation successfully cancelled: {}", reservation);
        return reservation;
    }

    @Override
    public List<Reservation> getReservationsByFlight(Long flightId) {
        logger.info("Fetching reservations for flightId={}", flightId);
        List<Reservation> reservations = reservationRepository.findByFlightId(flightId);
        logger.info("Reservations fetched: {}", reservations);
        return reservations;
    }
}
