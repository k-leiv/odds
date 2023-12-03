package com.assessment.odds.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class OddsExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(EntityNotFoundException e, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
