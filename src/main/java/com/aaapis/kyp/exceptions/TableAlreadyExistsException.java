package com.aaapis.kyp.exceptions;

public class TableAlreadyExistsException extends RuntimeException {
    public TableAlreadyExistsException(String message) {
        super(message);
    }
}
