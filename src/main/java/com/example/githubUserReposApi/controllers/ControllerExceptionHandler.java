package com.example.githubUserReposApi.controllers;

import com.example.githubUserReposApi.errors.UserNotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<?> handleCustomException(HttpClientErrorException.NotFound e) {
        UserNotFoundError error = new UserNotFoundError(e.getStatusCode().value(), "This account doesn't exist on GitHub", new Date());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}