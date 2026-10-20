package com.example.car_pricing.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Handles exceptions thrown by REST API controllers
@RestControllerAdvice
public class GlobalExceptionHandler {

	// Returns HTTP 400 when the request contains invalid input
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(
            IllegalArgumentException ex) {

        Map<String, String> errorResponse = Map.of(
            "error", ex.getMessage()
        );
        
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
}
}
