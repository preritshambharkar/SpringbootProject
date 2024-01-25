package com.springbootproject.controller;

import com.springbootproject.service.sampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

    @Autowired
    private sampleService sampleService;

    @GetMapping("/api/helloController")
    String helleController() {
        sampleService.sampleServiecFortune();
        return "hello this is hellController";
    }
}
