package com.example.f1stats.service;

import com.example.f1stats.dto.DriverDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class F1DriversService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://api.openf1.org/v1/drivers";

    public List<DriverDTO> getAllDrivers() {
        DriverDTO[] response = Objects.requireNonNull(
                restTemplate.getForObject(BASE_URL, DriverDTO[].class)
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

}
