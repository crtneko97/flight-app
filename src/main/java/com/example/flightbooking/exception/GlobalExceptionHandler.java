package com.example.flightbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleNotFound(NotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleValidation(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        for (FieldError fe : ex.getFieldErrors()) {
            errors.put(fe.getField(), fe.getDefaultMessage());
        }
        return errors;
    }

    // (Optional) catch-all
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handleOther(Exception ex) {
        return Map.of("error", "An unexpected error occurred");
    }
}
