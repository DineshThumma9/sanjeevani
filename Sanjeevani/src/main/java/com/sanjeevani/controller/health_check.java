package com.sanjeevani.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/health_check")
public class health_check {

    @GetMapping
    public String healthCheck() {
        return "Sanjeevani is up and running";
    }
}
