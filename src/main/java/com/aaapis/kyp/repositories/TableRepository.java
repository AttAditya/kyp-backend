package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Table,Long> {
    @Override
    Optional<Table> findById(Long tableId);
}
