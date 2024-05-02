package com.aaapis.kyp.services;

import com.aaapis.kyp.models.Table;

public interface ITableService {
    Table createTable(Table table);
    void deleteTable(Long tableId);
}
