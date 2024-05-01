package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import com.aaapis.kyp.models.Reservation;
import com.aaapis.kyp.services.bookingServiceIMPL.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    // User Actions Endpoints

    BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/search/{userid}")
    public ResponseEntity<?> getBookings(@PathVariable("userid") Long userId) {
        // Returns the list of bookings for a user

        System.out.println(userId + " got this from user");

        return ResponseEntity.ok(bookingService.getBookings(userId));

    }

    // Admin Actions Endpoints
    @GetMapping("/{reservationId}")
    public ResponseEntity<?> getBookingById(@PathVariable Long reservationId) {
        // Implement user login logic here
        System.out.println(reservationId + " got this from user as booking id");
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody BookingRequestDTO request) {
        // Implement adding Boooking Here

        return ResponseEntity.ok(bookingService.createBooking(request));
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<?> updateBooking(@PathVariable("reservationId") Long reservationId, @RequestBody BookingRequestDTO request) {
        System.out.println(reservationId + " got this from user as booking id");
        System.out.println(request.toString() + " got this from user as booking request");
        Reservation reservation = bookingService.mapToReservation(request);
        reservation.setId(reservationId);
        return ResponseEntity.ok(bookingService.updateBooking(reservation));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long reservationId) {
        System.out.println(reservationId + " got this from user as booking id");
        bookingService.cancelBooking(reservationId);
        return ResponseEntity.ok().build();
    }

}
