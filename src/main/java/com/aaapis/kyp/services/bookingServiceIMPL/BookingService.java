package com.aaapis.kyp.services.bookingServiceIMPL;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import com.aaapis.kyp.models.Reservation;
import com.aaapis.kyp.models.Table;
import com.aaapis.kyp.repositories.ReservationRepository;
import com.aaapis.kyp.repositories.RestaurantRepository;
import com.aaapis.kyp.repositories.TableRepository;
import com.aaapis.kyp.repositories.UserRepository;
import com.aaapis.kyp.services.IBookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("V1BookingService")
public class BookingService implements IBookingService {
    private final ReservationRepository reservationRepository;
    private  final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;

    private final TableRepository tableRepository;

    public BookingService(ReservationRepository reservationRepository, UserRepository userRepository, RestaurantRepository restaurantRepository, TableRepository tableRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.tableRepository = tableRepository;
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
    public Reservation createBooking(BookingRequestDTO bookingDTO) {

        Reservation reservation = mapToReservation(bookingDTO);

        return reservationRepository.save(reservation);

    }

    @Override
    public Reservation updateBooking(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation cancelBooking(Long bookingId) {
        return null;
    }

    public Reservation mapToReservation(BookingRequestDTO booking) {


        Reservation reservation = new Reservation();
        reservation.setBookingDate(booking.getBookingDate());
        reservation.setRestaurant(restaurantRepository.findById(booking.getRestaurantId()).orElseThrow());
        reservation.setBookingTime(booking.getBookingTime());
        reservation.setUser(userRepository.findById(booking.getUserId()).orElseThrow());

        List<Table> tables = new ArrayList<>();

        for(Long tableId : booking.getTableIds()) {
            Table table = tableRepository.findById(tableId).orElseThrow();
            tables.add(table);
        }
        reservation.setTables(tables);
        return reservation;
    }
}
