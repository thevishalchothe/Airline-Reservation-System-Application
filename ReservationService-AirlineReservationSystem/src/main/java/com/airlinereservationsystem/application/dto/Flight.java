package com.airlinereservationsystem.application.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
	
	
	private Long flightId;

	private String flightName;
	private String source;
	private String destination;
	private int totalSeats;
	private int availableSeats;

	private Date departureTime;

	private Date arrivalTime;
	
}
