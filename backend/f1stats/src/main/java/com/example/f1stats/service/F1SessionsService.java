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

    public List<SessionDTO> getSessions(Integer year, String sessionType, String circuitShortName) {
        String url = buildUrl(year, sessionType, circuitShortName);

        SessionDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, SessionDTO[].class)
        );

        if (BASE_URL.equals(url)) {
            return Arrays.stream(response)
                    .sorted(Comparator.comparing(SessionDTO::getDateStart).reversed())
                    .collect(Collectors.toMap(
                            SessionDTO::getCircuitKey,
                            session -> session,
                            (existing, replacement) -> existing
                    ))
                    .values()
                    .stream()
                    .sorted(Comparator.comparing(SessionDTO::getDateStart).reversed())
                    .toList();
        }

        return Arrays.stream(response).toList();
    }

    private String buildUrl(Integer year, String sessionType, String circuitShortName) {
        String url = BASE_URL;

        if (year != null || sessionType != null || circuitShortName != null) {
            url += "?";

            if (year != null) {
                url += "year=" + year;
            }

            if (sessionType != null) {
                url += "session_type=" + sessionType;
            }

            if (circuitShortName != null) {
                url += "circuit_short_name=" + circuitShortName;
            }
        }

        return url;
    }

}
