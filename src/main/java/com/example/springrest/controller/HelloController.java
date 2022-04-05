package com.example.springrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("This is  Spring Security MVC application written by Ilmira");
        messages.add("1.0 version by february'24 ");
        model.addAttribute("messages", messages);
        return "index";
    }

}