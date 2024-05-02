package com.aaapis.kyp.services.tableServiceIMPL;

import com.aaapis.kyp.exceptions.TableNotFoundException;
import com.aaapis.kyp.models.Table;
import com.aaapis.kyp.repositories.TableRepository;
import com.aaapis.kyp.services.ITableService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TableService implements ITableService {
    private final TableRepository tableRepository;

    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public Table createTable(Table table) {
        if (table.getReservations() == null) {
            table.setReservations(new ArrayList<>());
        }

        return tableRepository.save(table);
    }

    @Override
    public void deleteTable(Long tableId) {
        Optional<Table> table = tableRepository.findById(tableId);
        tableRepository.deleteById(tableId);

        if (table.isEmpty()) {
            throw new TableNotFoundException("Table not found: " + tableId);
        }
    }
}
