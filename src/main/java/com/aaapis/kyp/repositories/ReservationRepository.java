package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    ReservationRepository save(Reservation reservation);
    Optional<Reservation> findById(Long reservationId);
}
