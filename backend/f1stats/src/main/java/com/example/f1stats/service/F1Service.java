package com.example.f1stats.service;

import com.example.f1stats.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class F1Service {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_DRIVERS_URL = "https://api.openf1.org/v1/drivers";
    private static final String BASE_SESSIONS_URL = "https://api.openf1.org/v1/sessions";
    private static final String BASE_RESULTS_URL = "https://api.openf1.org/v1/session_result";

    public List<DriverDTO> getAllDrivers() {
        delay();

        DriverDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(BASE_DRIVERS_URL, DriverDTO[].class)
        );

        return Arrays.stream(response)
                .collect(Collectors.toMap(
                        DriverDTO::getFullName,
                        d -> d,
                        (existing, replacement) -> existing
                ))
                .values()
                .stream()
                .toList();
    }

    private Map<Integer, DriverDTO> getDriversBySessionKey(Long sessionKey) {
        delay();

        String url = BASE_DRIVERS_URL +
                "?session_key=" + sessionKey;

        DriverDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, DriverDTO[].class)
        );

        return Arrays.stream(response)
                .collect(Collectors.toMap(DriverDTO::getDriverNumber, d -> d));
    }

    public DriverDTO getDriverBySessionAndNumber(Long sessionKey, Integer driverNumber) {
        delay();

        String url = BASE_DRIVERS_URL +
                "?session_key=" + sessionKey +
                "&driver_number=" + driverNumber;

        DriverDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, DriverDTO[].class)
        );

        if (response.length == 0) return null;
        return response[0];
    }

    public List<SessionDTO> getSessions(Integer year) {
        if (year == null) {
            throw new IllegalArgumentException();
        }

        delay();

        String url = BASE_SESSIONS_URL + "?year=" + year;

        SessionDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, SessionDTO[].class)
        );

        Map<String, List<SessionDTO>> sessionsByCircuit = Arrays.stream(response)
                .collect(Collectors.groupingBy(SessionDTO::getCircuitShortName));

        return sessionsByCircuit.values().stream()
                .map(this::mergeSessionsIntoWeekend)
                .sorted(Comparator.comparing(SessionDTO::getDateStart))
                .toList();
    }

    public List<SessionDTO> getSessionInfo(Integer year, String circuitName) {
        if (circuitName == null) {
            throw new IllegalArgumentException();
        }

        delay();

        String url = BASE_SESSIONS_URL +
                "?year=" + year +
                "&circuit_short_name=" + circuitName;

        SessionDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, SessionDTO[].class)
        );

        return Arrays.stream(response)
                .sorted(Comparator.comparing(SessionDTO::getDateStart).reversed())
                .toList();
    }

    public List<SessionResultsDTO> getSessionResults(Long sessionKey) {
        if (sessionKey == null) {
            throw new IllegalArgumentException();
        }

        delay();

        String url = BASE_RESULTS_URL + "?session_key=" + sessionKey;

        SessionResultsDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(url, SessionResultsDTO[].class)
        );

        delay();

        Map<Integer, DriverDTO> driversBySession = getDriversBySessionKey(sessionKey);

        return Arrays.stream(response)
                //.sorted(Comparator.comparing(SessionResultsDTO::getPosition))
                .map(result -> {
                    DriverDTO driver = driversBySession.get(result.getDriverNumber());
                    return new SessionResultsDTOBuilder(result)
                            .withDriverInfo(driver)
                            .build();
                })
                .toList();
    }

    private SessionDTO mergeSessionsIntoWeekend(List<SessionDTO> sessions) {
        SessionDTO first = sessions.getFirst();

        Date start = sessions.stream()
                .map(SessionDTO::getDateStart)
                .min(Date::compareTo)
                .orElse(null);

        Date end = sessions.stream()
                .map(SessionDTO::getDateEnd)
                .max(Date::compareTo)
                .orElse(null);

        return new SessionDTOBuilder()
                .withMeetingKey(first.getMeetingKey())
                .withSessionKey(first.getSessionKey())
                .withLocation(first.getLocation())
                .withDateStart(start)
                .withDateEnd(end)
                .withCountryKey(first.getCountryKey())
                .withCountryCode(first.getCountryCode())
                .withCountryName(first.getCountryName())
                .withCircuitKey(first.getCircuitKey())
                .withCircuitShortName(first.getCircuitShortName())
                .withYear(first.getYear())
                .build();
    }

    private void delay() {
        try {
            // Wait 3 seconds before calling the API
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted while waiting", e);
        }
    }

}
