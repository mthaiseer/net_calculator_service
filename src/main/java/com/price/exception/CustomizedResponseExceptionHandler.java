package com.price.exception;

import com.price.vo.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RateNotFoundException.class)
    public final ResponseEntity<Object> handleRateNotFoundException(RateNotFoundException ex) {
        ExceptionResponse.ExceptionResponseBuilder exception = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(ex.getLocalizedMessage());

        return new ResponseEntity(exception.build(), HttpStatus.BAD_REQUEST);
    }
}
