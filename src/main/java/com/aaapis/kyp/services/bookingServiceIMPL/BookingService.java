package com.aaapis.kyp.services.bookingServiceIMPL;

import com.aaapis.kyp.dtos.BookingRequestDTO;
import com.aaapis.kyp.exceptions.RestaurantNotFoundException;
import com.aaapis.kyp.exceptions.TableNotFoundException;
import com.aaapis.kyp.exceptions.UserNotFoundException;
import com.aaapis.kyp.models.Reservation;
import com.aaapis.kyp.models.Restaurant;
import com.aaapis.kyp.models.Table;
import com.aaapis.kyp.models.User;
import com.aaapis.kyp.repositories.ReservationRepository;
import com.aaapis.kyp.repositories.RestaurantRepository;
import com.aaapis.kyp.repositories.TableRepository;
import com.aaapis.kyp.repositories.UserRepository;
import com.aaapis.kyp.services.IBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Reservation> getBookings(Long userId) {

        if(userId == null) {
            throw new IllegalArgumentException("User Id is required");
        }
        return reservationRepository.findByUserId(userId);
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
        System.out.println("Updating booking");
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation cancelBooking(Long bookingId) {
        Optional<Reservation> reservation = reservationRepository.findById(bookingId);

        if (reservation.isEmpty()) {
            throw new RuntimeException("Reservation not found: " + bookingId);
        }

        reservationRepository.deleteById(bookingId);
        return reservation.get();
    }

    public Reservation mapToReservation(BookingRequestDTO booking) {
        Reservation reservation = new Reservation();

        System.out.println("Booking Request: " + booking);

        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(booking.getRestaurantId());

        if (optionalRestaurant.isEmpty()) {
            throw new RestaurantNotFoundException("Restaurant not found: " + booking.getRestaurantId());
        }

        reservation.setRestaurant(optionalRestaurant.get());

        System.out.println("Booking Start Time: " + booking.getStartTime());
        System.out.println("Booking End Time: " + booking.getFinishTime());

        reservation.setStartTime(booking.getStartTime());
        reservation.setFinishTime(booking.getFinishTime());

        Optional<User> optionalUser = userRepository.findById(booking.getUserId());

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found: " + booking.getUserId());
        }

        System.out.println("User: " + booking.getUserId());

        User user = optionalUser.get();
        user.getHistory().add(reservation);
        reservation.setUser(user);

        System.out.println("Table: " + booking.getTableId());

        Optional<Table> optionalTable = tableRepository.findById(booking.getTableId());

        if (optionalTable.isEmpty()) {
            throw new TableNotFoundException("Table not found: " + booking.getTableId());
        }

        Table table = optionalTable.get();
        table.getReservations().add(reservation);

        System.out.println("Found Table: " + table);

        reservation.setTable(table);

//        Table table_ = tableRepository.save(table);
//        System.out.println("Saved Table: " + table_);

//        User user_ = userRepository.save(user);
//        System.out.println("Saved User: " + user_);

        return reservationRepository.save(reservation);
    }
}
