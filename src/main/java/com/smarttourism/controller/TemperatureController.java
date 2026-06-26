package com.smarttourism.controller;

import com.smarttourism.model.Temperature;
import com.smarttourism.model.TemperatureResponse;
import com.smarttourism.service.TemperatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class TemperatureController {
    private final TemperatureService temperatureService;

    @PostMapping("/my-tourist-places/{city}")
    public ResponseEntity<Void> captureTemperature(
            @PathVariable String city,
            @RequestBody Temperature temperature) {
        log.info("POST request: Capture temperature for city: {}", city);
        temperatureService.saveTemperature(city, temperature);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/temperatures/{city}")
    public ResponseEntity<List<Temperature>> getTemperaturesByCity(@PathVariable String city) {
        log.info("GET request: Fetch temperatures for city: {}", city);
        List<Temperature> temperatures = temperatureService.getTemperaturesByCity(city);
        if (temperatures.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(temperatures);
    }

    @GetMapping("/receive-all-temperatures")
    public ResponseEntity<TemperatureResponse> receiveAllTemperatures() {
        log.info("GET request: Receive all temperatures");
        return ResponseEntity.ok(temperatureService.getAllTemperatures());
    }
}