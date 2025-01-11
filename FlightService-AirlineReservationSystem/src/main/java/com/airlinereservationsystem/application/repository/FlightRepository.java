package com.airlinereservationsystem.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlinereservationsystem.application.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>  {

}
