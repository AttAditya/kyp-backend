package com.aaapis.kyp.exceptions;

public class EmptyGuestListException extends RuntimeException {
    public EmptyGuestListException (String message)
    {
        super (message);
    }
}
