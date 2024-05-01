package com.aaapis.kyp.exceptions;

public class TableNotFoundException extends RuntimeException {
    public TableNotFoundException  (String message) {
        super(message);
    }
}
