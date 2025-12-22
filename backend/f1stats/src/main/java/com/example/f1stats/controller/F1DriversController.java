package com.example.f1stats.controller;

import com.example.f1stats.dto.DriverDTO;
import com.example.f1stats.service.F1DriversService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class F1DriversController {

    private final F1DriversService f1DriversService;

    public F1DriversController(F1DriversService f1DriversService) {
        this.f1DriversService = f1DriversService;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(f1DriversService.getAllDrivers());
    }

}
