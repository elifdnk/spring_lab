package com.cydeo.lab08rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class,RuntimeException.class, Throwable.class})
    public ResponseEntity<ExceptionWrapper> handleGenericExceptions(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionWrapper("Action failed: An error occurred!", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler({AddressNotFoundException.class,CustomerNotFoundException.class, DiscountNotFoundException.class, OrderNotFoundException.class, ProductNotFoundException.class})
    public ResponseEntity<ExceptionWrapper> handleNotFoundExceptions(Throwable exception){
        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(exception.getMessage(),HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionWrapper);
    }

    @ExceptionHandler(CurrencyInvalidException.class)
    public ResponseEntity<ExceptionWrapper> handleCurrencyInvalidException(CurrencyInvalidException exception) {
        ExceptionWrapper exceptionWrapper = new ExceptionWrapper(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionWrapper);
    }

}
