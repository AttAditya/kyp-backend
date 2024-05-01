package com.aaapis.kyp.exceptions;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException (String message){ super(message); }
}
