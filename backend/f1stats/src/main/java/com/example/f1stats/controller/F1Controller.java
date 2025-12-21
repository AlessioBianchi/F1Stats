package com.example.f1stats.controller;

import com.example.f1stats.service.F1Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class F1Controller {

    private final F1Service f1Service;

    public F1Controller(F1Service f1Service) {
        this.f1Service = f1Service;
    }

    @GetMapping("/ping")
    public String test() {
        return "OK";
    }

    @GetMapping("/drivers")
    public ResponseEntity<String> getDrivers() {
        return ResponseEntity.ok(f1Service.getDrivers());
    }
}
