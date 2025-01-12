package com.airlinereservationsystem.application.emailutility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.airlinereservationsystem.application.model.Reservation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    /**
     * Send a booking confirmation email.
     */
    public void sendBookingConfirmation(String email, Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Booking Confirmation");
        message.setText("Dear " + reservation.getPassengerName() + ",\n\nYour booking is confirmed. Details:\n"
                + "Flight ID: " + reservation.getFlightId() + "\n"
                + "Number of Seats: " + reservation.getNumberOfSeats() + "\n"
                + "Booking Date: " + reservation.getBookingDate() + "\n\nThank you for choosing us.");
        mailSender.send(message);
        logger.info("Booking confirmation email sent to {}", email);
    }

    /**
     * Send a cancellation confirmation email.
     */
    public void sendCancellationConfirmation(String email, Reservation reservation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Cancellation Confirmation");
        message.setText("Dear " + reservation.getPassengerName() + ",\n\nYour booking has been cancelled. Details:\n"
                + "Flight ID: " + reservation.getFlightId() + "\n"
                + "Number of Seats: " + reservation.getNumberOfSeats() + "\n"
                + "Booking Date: " + reservation.getBookingDate() + "\n\nWe are sorry for the inconvenience.");
        mailSender.send(message);
        logger.info("Cancellation confirmation email sent to {}", email);
    }
}
