package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location,Long> {
    @Override
    Optional<Location> findById(Long locationId);
}
