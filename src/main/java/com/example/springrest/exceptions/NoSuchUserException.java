package com.example.springrest.exceptions;

public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException(String message){
        super(message);
    }
}
