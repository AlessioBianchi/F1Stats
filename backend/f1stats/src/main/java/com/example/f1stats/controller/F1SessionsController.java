package com.example.f1stats.controller;

import com.example.f1stats.dto.SessionDTO;
import com.example.f1stats.service.F1SessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class F1SessionsController {

    private final F1SessionsService f1SessionsService;

    public F1SessionsController(F1SessionsService f1SessionsService) {
        this.f1SessionsService = f1SessionsService;
    }

    @GetMapping("/sessions")
    public ResponseEntity<List<SessionDTO>> getSessions(
            @RequestParam Integer year
    ) {
        return ResponseEntity.ok(f1SessionsService.getSessions(year));
    }

    @GetMapping("/sessions/info")
    public ResponseEntity<List<SessionDTO>> getSessionInfo(
            @RequestParam Integer year,
            @RequestParam String circuitName
    ) {
        return ResponseEntity.ok(f1SessionsService.getSessionInfo(year, circuitName));
    }

}
