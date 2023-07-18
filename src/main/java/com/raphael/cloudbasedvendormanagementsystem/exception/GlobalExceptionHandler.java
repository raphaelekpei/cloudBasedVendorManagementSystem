package com.raphael.cloudbasedvendormanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CloudVendorNotFoundException.class)
    public ResponseEntity<?> CloudVendorNotFoundExceptionHandler(CloudVendorNotFoundException cloudVendorNotFoundException){
        APIErrorResponse apiErrorResponse = APIErrorResponse.builder()
                .errorMessage(cloudVendorNotFoundException.getMessage())
                .timestamp(LocalDateTime.now())
                .isSuccessful(false)
                .status(HttpStatus.NOT_FOUND)
                .build();
        // return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND); TODO: any of the return responses works fine
        return ResponseEntity.ok(apiErrorResponse);
    }

    @ExceptionHandler(value = CloudVendorAlreadyExistException.class)
    public ResponseEntity<?> CloudVendorAlreadyExistExceptionHandler(CloudVendorAlreadyExistException cloudVendorAlreadyExistException){
        APIErrorResponse apiErrorResponse = APIErrorResponse.builder()
                .errorMessage(cloudVendorAlreadyExistException.getMessage())
                .timestamp(LocalDateTime.now())
                .isSuccessful(false)
                .status(HttpStatus.ALREADY_REPORTED)
                .build();
        // return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND); TODO: any of the return responses works fine
        return ResponseEntity.ok(apiErrorResponse);
    }

}
