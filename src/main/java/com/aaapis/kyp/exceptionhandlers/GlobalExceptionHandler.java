package com.aaapis.kyp.exceptionhandlers;

import com.aaapis.kyp.dtos.ExceptionDTO;
import com.aaapis.kyp.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleUserNotFoundException(UserNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleRestaurantNotFoundException(RestaurantNotFoundException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidBookingException(InvalidBookingException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidPasswordException(InvalidPasswordException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ExceptionDTO> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(EmptyGuestListException.class)
    public ResponseEntity<ExceptionDTO> handleEmptyGuestListException(EmptyGuestListException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(exception.getMessage());
        exceptionDTO.setTime(new Date());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

}
