package com.example.f1stats.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class F1Service {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://api.openf1.org/v1";

    public String getDrivers() {
        return restTemplate.getForObject(BASE_URL + "/drivers", String.class);
    }

}
