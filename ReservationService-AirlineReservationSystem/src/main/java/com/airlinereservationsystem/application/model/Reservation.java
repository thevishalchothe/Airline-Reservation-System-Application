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
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;

	private Long flightId;
	private String passengerName;
	private String email;
	private int numberOfSeats;

	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;

	private String status; // BOOKED or CANCELLED

}
