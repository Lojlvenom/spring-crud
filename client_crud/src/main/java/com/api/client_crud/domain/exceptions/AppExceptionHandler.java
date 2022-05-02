package com.api.client_crud.domain.exceptions;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends RuntimeException{
    @ExceptionHandler(Exception.class)
    private ResponseEntity handleException(Exception ex) {
        DefaultExceptionModel error = new DefaultExceptionModel(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), ZonedDateTime.now());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
