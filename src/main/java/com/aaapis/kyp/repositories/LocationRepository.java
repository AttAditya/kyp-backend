package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    Optional<Location> findById(Long locationId);
}
