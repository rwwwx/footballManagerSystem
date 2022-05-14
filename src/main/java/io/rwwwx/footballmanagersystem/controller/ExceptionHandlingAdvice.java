package io.rwwwx.footballmanagersystem.controller;

import io.rwwwx.footballmanagersystem.exception.InvalidIdException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingAdvice {

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<String> handle(InvalidIdException e) {
        log.error("handled an exception - ", e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
