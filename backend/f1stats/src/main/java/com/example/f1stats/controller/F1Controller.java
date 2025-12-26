package com.example.f1stats.controller;

import com.example.f1stats.dto.DriverDTO;
import com.example.f1stats.dto.SessionDTO;
import com.example.f1stats.dto.SessionResultsDTO;
import com.example.f1stats.service.F1Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class F1Controller {

    private final F1Service f1Service;

    public F1Controller(F1Service f1Service) {
        this.f1Service = f1Service;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(f1Service.getAllDrivers());
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<SessionDTO>> getSessions(
            @RequestParam Integer year
    ) {
        return ResponseEntity.ok(f1Service.getSessions(year));
    }

    @GetMapping("/sessions/infos")
    public ResponseEntity<List<SessionDTO>> getSessionInfo(
            @RequestParam Integer year,
            @RequestParam String circuitName
    ) {
        return ResponseEntity.ok(f1Service.getSessionInfo(year, circuitName));
    }

    @GetMapping("/sessions/results")
    public ResponseEntity<List<SessionResultsDTO>> getRaceResults(
            @RequestParam Long sessionKey
    ) {
        return ResponseEntity.ok(f1Service.getSessionResults(sessionKey));
    }

}
