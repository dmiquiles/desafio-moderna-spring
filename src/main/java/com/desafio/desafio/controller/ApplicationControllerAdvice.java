package com.desafio.desafio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.desafio.desafio.exception.RecordFoundException;
import com.desafio.desafio.exception.RecordNotFoundException;


@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(RecordFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleFoundException(RecordFoundException ex) {
        return ex.getMessage();
    }
    
}
