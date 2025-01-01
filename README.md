# **Airline Reservation System Application** 🌍✈️

## **What is the Airline Reservation System?** 🌐

The **Airline Reservation System** is a modern web application designed to simplify flight booking and management. Utilizing a **Microservices Architecture**, the backend is built with **Spring Boot** ⚙️, and the frontend is crafted with **Angular** (currently unsettled), ensuring smooth communication through **REST APIs** and email notifications. This system allows users to book 📅, cancel ❌, and manage reservations while receiving real-time notifications 📲 and updates 🔄.

---

## **Features** ✨

### **Backend Features** 🌐
- **Book Ticket** 🎟️: Enables passengers to book tickets for available flights, with **confirmation emails** sent upon successful booking.
- **Cancel Ticket** 🛑🛬: Allows passengers to cancel bookings and sends **cancellation emails** for notification.
- **View Reservation** ✅: Retrieves details of a specific reservation using the ticket ID.
- **View All Reservations** 📅: Lists all reservations for a specific flight.
- **Flight Availability** 🛫: Displays available seats for flights.
- **Email Notifications** 📧: Sends timely updates for bookings, cancellations, and flight status changes.

---

## **Architecture** 🏗️

The **Airline Reservation System** leverages a **Microservices Architecture** for scalability and performance:

### **Backend Services** 🛠️
- **Flight Service** 🛫: Manages flight schedules, seat availability, and details.
- **Reservation Service** 🎫: Handles ticket bookings, cancellations, and user reservations.

---

## **Technologies Used** 💻🔧

### **Backend Technologies**
- **Java** ☕️: The core programming language.
- **Spring Boot** 🌱: Framework for microservices development.
- **Spring Data JPA** 📊: Simplifies database access.
- **Hibernate** 🔄: Ensures efficient ORM-based database interaction.
- **Lombok** 📜: Reduces boilerplate code.
- **SLF4J** 📖: Provides logging capabilities.
- **MySQL** 🗄️: Relational database for storing flights, reservations, and user data.
- **Spring Email** 📧: Sends automated booking and cancellation emails.
