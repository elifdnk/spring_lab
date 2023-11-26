package com.cydeo.lab08rest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionWrapper {
    
    private String message;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;
    
    public ExceptionWrapper(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.localDateTime = LocalDateTime.now();
    }
    
}