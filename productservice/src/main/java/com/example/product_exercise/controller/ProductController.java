package com.example.product_exercise.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-config")
public class ProductController {
    // The :Fallback text prevents a crash if GitHub is missing the key
    @Value("${service.message:Fallback: Could not read from Config Server!}")
    private String message;

    @GetMapping
    public String getMessage() {
        return this.message;
    }
//    @GetMapping("/all")
//    public String getCategories() {
//        return this.message;
//    }
}
