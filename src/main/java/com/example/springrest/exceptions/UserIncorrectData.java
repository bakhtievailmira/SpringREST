package com.example.springrest.exceptions;

import org.springframework.stereotype.Component;

@Component
public class UserIncorrectData {
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
