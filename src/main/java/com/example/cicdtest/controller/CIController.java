package com.example.cicdtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class CIController {
    @GetMapping("/") 
    public String hello() { 
        return "Hello World!"; 
    }
}
