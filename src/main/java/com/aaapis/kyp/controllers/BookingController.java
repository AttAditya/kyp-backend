package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    // User Actions Endpoints

    @GetMapping
    public ResponseEntity<?> getBookings(@RequestParam(name = "customerId", defaultValue = "", required = false) Long customerId) {
        // Implement user login logic here
        System.out.println("return the bookings of this user with " + customerId);
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
        // Implement user login logic here
        System.out.println(request.getBookingTime() + " got this from user");
        return ResponseEntity.ok().build();
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
