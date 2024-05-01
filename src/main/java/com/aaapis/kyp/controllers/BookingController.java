package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import com.aaapis.kyp.models.Reservation;
import com.aaapis.kyp.services.bookingServiceIMPL.BookingService;
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

    @GetMapping
    public ResponseEntity<?> getBookings(@RequestParam(name = "userid", defaultValue = "", required = false) Long userId) {
        // Implement user login logic here
        System.out.println("return the bookings of this user with " + userId);
        return ResponseEntity.ok().build();
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
    public ResponseEntity<?> updateBooking(@PathVariable Long reservationId, @RequestBody BookingRequestDTO request) {
        // Implement user login logic here
        System.out.println(reservationId + " got this from user as booking id");
        System.out.println(request.getBookingTime() + " got this from user");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long reservationId) {
        // Implement user login logic here
        System.out.println(reservationId + " got this from user as booking id");
        return ResponseEntity.ok().build();
    }

}
