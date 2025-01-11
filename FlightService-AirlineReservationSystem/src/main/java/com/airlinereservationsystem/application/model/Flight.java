package com.airlinereservationsystem.application.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flightId;

	private String flightName;
	private String source;
	private String destination;
	private int totalSeats;
	private int availableSeats;

	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;
	
}
