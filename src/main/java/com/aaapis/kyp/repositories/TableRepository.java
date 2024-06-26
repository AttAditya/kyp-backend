package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableRepository extends JpaRepository<Table, Long> {
    Optional<Table> findById(Long tableId);

    @Override
    Table save(Table table);
}
