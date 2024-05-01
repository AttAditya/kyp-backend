package com.aaapis.kyp.services.bookingServiceIMPL;

import com.aaapis.kyp.models.Reservation;
import com.aaapis.kyp.repositories.CustomerRepository;
import com.aaapis.kyp.repositories.ReservationRepository;
import com.aaapis.kyp.services.IBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("V1BookingService")
public class BookingService implements IBookingService {
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    public BookingService(ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Reservation> getBookings(Long customerId) {
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
