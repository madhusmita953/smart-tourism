package com.smarttourism.controller;

import com.smarttourism.model.ApiEndpointRequest;
import com.smarttourism.service.ExternalApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api-endpoint")
@RequiredArgsConstructor
@Slf4j
public class EndpointRegistrationController {
    private final ExternalApiService externalApiService;

    @PostMapping
    public ResponseEntity<String> registerEndpoint(@RequestBody ApiEndpointRequest request) {
        log.info("POST request: Register API endpoint");
        log.info("Endpoint: {}", request.getEndpoint());
        log.info("Encoded Hostname: {}", request.getEncodedHostname());
        
        String decodedHostname = externalApiService.decodeHostname(request.getEncodedHostname());
        log.info("Decoded Hostname: {}", decodedHostname);
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Endpoint registered successfully. Ready to receive temperatures.");
    }
}