# **Airline Reservation System Application** 🌍✈️

## **What is the Airline Reservation System?** 🌐

The **Airline Reservation System** is a modern web application designed to simplify flight booking and management. Utilizing a **Microservices Architecture**, the backend is built with **Spring Boot** ⚙️, and the frontend is crafted with **Angular** (currently unsettled), ensuring smooth communication through **REST APIs** and email notifications. This system allows users to book 📅, cancel ❌, and manage reservations while receiving real-time notifications 📲 and updates 🔄.

---

## **Architecture** 🏗️

The **Airline Reservation System** leverages a **Microservices Architecture** for scalability and performance:


## Backend Services 🛠️

### **Flight Service 🛫**
The **Flight Service** is responsible for managing flight-related data. It handles the following tasks:

- **Flight Schedules & Management**: 
  - Manages flight schedules, including departure times, flight routes, and aircraft details.
  
- **Seat Availability**: 
  - Keeps track of available seats for each flight and manages seat reservations.
  
- **Flight Information**: 
  - Provides detailed flight information such as flight ID, departure and arrival times, and available seats.
  
- **Booking Integration**: 
  - Works closely with the **Reservation Service** to update seat availability and flight details after a booking or cancellation.

---

### **Reservation Service 🎫**
The **Reservation Service** handles ticket bookings, cancellations, and reservation management. Its responsibilities include:

- **Ticket Booking**: 
  - Manages the booking of flight tickets, including seat selection and passenger details.
  
- **Reservation Management**: 
  - Handles the creation, update, and retrieval of flight reservations. Users can view or modify their reservations.
  
- **Cancellation Handling**: 
  - Manages the cancellation of reservations, updating seat availability and sending cancellation notifications to users.
  
- **User Notifications**: 
  - Sends email notifications for booking confirmations, cancellations, and other related updates.
  
- **Flight Integration**: 
  - Communicates with the **Flight Service** to fetch flight details and update seat availability after a booking or cancellation.

---

## How It Works 🛠️

1. **Flight Service** manages all flight-related operations, such as searching for flights, updating seat availability, and storing flight details.
2. **Reservation Service** allows users to book or cancel tickets. Upon booking, it checks flight availability, deducts seats, and sends a booking confirmation email.
3. **Email Notifications** are sent to users upon booking or cancellation, providing confirmation or updates on the status of their reservations.

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

---

### **Prerequisites** 🛠️

Before you begin, make sure you have the following installed:

- **Java JDK 11 or later**: Download from [Oracle's website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
- **Postman**: Install for API testing from [Postman's website](https://www.postman.com/downloads/).
- **Eclipse IDE**: Download from [Eclipse's website](https://www.eclipse.org/downloads/packages/release/2023-09/r) or use your preferred IDE.

---

## **Installation** 🛠️

### **Backend Setup**
-  Clone the Repository:
   ```bash
   git clone https://github.com/thevishalchothe/airline-reservation-system-application.git
   cd airline-reservation-system-application

---

## **Contributing** 💡

We welcome contributions to the **Airline Reservation System**! Here's how you can contribute:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Implement your changes and commit them with clear messages.
3. Submit a pull request for review.

If you have any questions or need help, feel free to contact me at [vishalchothe134@gmail.com](mailto:vishalchothe134@gmail.com).

---

## **Conclusion & License** 📜

Using an open-source license encourages collaboration and contributions from the community, leading to continuous improvement.

See the [LICENSE](https://github.com/thevishalchothe) file for more information.

---



## **Thank You and Best Regards!** 🙏🎉

