package com.aaapis.kyp.services.bookingServiceIMPL;

import com.aaapis.kyp.models.Reservation;
import com.aaapis.kyp.services.IBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("V1BookingService")
public class BookingService implements IBookingService {
    @Override
    public List<Reservation> getBookings() {
        return List.of();
    }

    @Override
    public List<Reservation> getBookingsByName(String userName) {
        return List.of();
    }

    @Override
    public Reservation getBookingById(Long bookingId) {
        return null;
    }

    @Override
    public Reservation createBooking(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation updateBooking(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation cancelBooking(Long bookingId) {
        return null;
    }
}
