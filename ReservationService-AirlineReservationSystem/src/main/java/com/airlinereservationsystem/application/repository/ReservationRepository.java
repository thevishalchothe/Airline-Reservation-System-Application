package com.airlinereservationsystem.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlinereservationsystem.application.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByFlightId(Long flightId);

}
