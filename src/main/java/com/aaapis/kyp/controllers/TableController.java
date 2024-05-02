package com.aaapis.kyp.controllers;

import com.aaapis.kyp.models.Table;
import com.aaapis.kyp.services.ITableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
public class TableController {
    private final ITableService tableService;

    public TableController(ITableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<?> createTable(@RequestBody Table table) {
        System.out.println("Creating table: " + table);
        return ResponseEntity.ok(tableService.createTable(table));
    }

    @DeleteMapping("/{tableId}")
    public ResponseEntity<?> deleteTable(@PathVariable("tableId") Long tableId) {
        System.out.println("Deleting table: " + tableId);
        tableService.deleteTable(tableId);
        return ResponseEntity.ok().build();
    }
}
