package com.smarttourism.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smarttourism.model.TemperatureResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExternalApiService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final TemperatureService temperatureService;

    public void fetchTemperaturesFromExternalApp() {
        log.info("Fetching temperatures from external Smart Tourism app");
        try {
            log.info("Ready to receive temperature data from Smart Tourism app");
        } catch (Exception e) {
            log.error("Error fetching temperatures from external app", e);
        }
    }

    public String getEncodedHostname(String hostname) {
        return Base64.getEncoder().encodeToString(hostname.getBytes());
    }

    public String decodeHostname(String encodedHostname) {
        return new String(Base64.getDecoder().decode(encodedHostname));
    }
}