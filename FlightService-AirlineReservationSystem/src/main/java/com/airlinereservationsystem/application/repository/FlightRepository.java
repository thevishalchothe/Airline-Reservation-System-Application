package com.airlinereservationsystem.application.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlinereservationsystem.application.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>  {

	List<Flight> findBySourceAndDestinationAndDepartureTimeAfter(String source, String destination, Date departureDate);

	Optional<Flight> findById(Long id);

}
