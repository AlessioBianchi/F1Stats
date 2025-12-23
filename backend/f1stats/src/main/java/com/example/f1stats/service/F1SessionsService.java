package com.example.f1stats.service;

import com.example.f1stats.dto.SessionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class F1SessionsService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://api.openf1.org/v1/sessions";

    public List<SessionDTO> getSessions(Integer year) {
        if (year == null) {
            throw new IllegalArgumentException();
        }

        String url = BASE_URL + "?year=" + year;

        SessionDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, SessionDTO[].class)
        );

        return Arrays.stream(response)
                .filter(session -> session.getSessionName().equals("Race"))
                .sorted(Comparator.comparing(SessionDTO::getDateStart))
                .toList();
    }

    public List<SessionDTO> getSessionInfo(Integer year, String circuitName) {
        if (circuitName == null) {
            throw new IllegalArgumentException();
        }

        String url = BASE_URL +
                "?year=" + year +
                "&circuit_short_name=" + circuitName;

        SessionDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, SessionDTO[].class)
        );

        return Arrays.stream(response)
                .sorted(Comparator.comparing(SessionDTO::getDateStart).reversed())
                .toList();
    }

}
