package com.example.springrest.controller;

import com.example.springrest.exceptions.NoSuchUserException;
import com.example.springrest.exceptions.UserIncorrectData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException (NoSuchUserException exception){

        UserIncorrectData  userIncorrectData =new UserIncorrectData();
        userIncorrectData.setInfo(exception.getMessage());

        return  new ResponseEntity<>(userIncorrectData, HttpStatus.NOT_FOUND) ;
    }
}
