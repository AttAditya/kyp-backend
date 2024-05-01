package com.aaapis.kyp.controllers;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    // User Actions Endpoints

    @PostMapping
    public ResponseEntity<?> getBookings(@RequestBody Long id) {
        // Implement user login logic here
        System.out.println("return the bookings of this user with " + id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{name}")
    public ResponseEntity<?> searchBookings(@PathVariable String name) {
        // Implement user login logic here
        System.out.println(name + "got this from user");
        return ResponseEntity.ok().build();
    }

    // Admin Actions Endpoints
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable Long id) {
        // Implement user login logic here
        System.out.println(id + " got this from user as booking id");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody BookingRequestDTO request) {
        // Implement user login logic here
        System.out.println(request.getBookingTime() + " got this from user");
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(@PathVariable Long id, @RequestBody BookingRequestDTO request) {
        // Implement user login logic here
        System.out.println(id + " got this from user as booking id");
        System.out.println(request.getBookingTime() + " got this from user");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) {
        // Implement user login logic here
        System.out.println(id + " got this from user as booking id");
        return ResponseEntity.ok().build();
    }


}
