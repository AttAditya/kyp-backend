package com.aaapis.kyp.services;

import com.aaapis.kyp.models.Reservation;

import java.util.List;

public interface IBookingService {
    List<Reservation> getBookings();
    List<Reservation> getBookingsByName(String userName);
    Reservation getBookingById(Long bookingId);
    Reservation createBooking(Reservation reservation);
    Reservation updateBooking(Reservation reservation);
    Reservation cancelBooking(Long bookingId);
}