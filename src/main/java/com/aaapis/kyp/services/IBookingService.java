package com.aaapis.kyp.services;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import com.aaapis.kyp.models.Reservation;

import java.util.List;

public interface IBookingService {
    List<Reservation> getBookings(Long customerId);
    Reservation getBookingById(Long bookingId);

    Reservation createBooking(BookingRequestDTO bookingDTO);

    Reservation updateBooking(Reservation reservation);
    Reservation cancelBooking(Long bookingId);
}
