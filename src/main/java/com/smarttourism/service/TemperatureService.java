package com.smarttourism.service;

import com.smarttourism.model.Temperature;
import com.smarttourism.model.TemperatureResponse;
import com.smarttourism.repository.TemperatureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class TemperatureService {
    private final TemperatureRepository repository;

    public void saveTemperature(String city, Temperature temperature) {
        log.info("Saving temperature for city: {} - {}°{}", 
                city, temperature.getTemperature(), temperature.getUnit());
        temperature.setCity(city);
        repository.save(city, temperature);
    }

    public List<Temperature> getTemperaturesByCity(String city) {
        log.info("Fetching temperatures for city: {}", city);
        return repository.getTemperatures(city);
    }

    public TemperatureResponse getAllTemperatures() {
        log.info("Fetching all temperatures");
        Map<String, List<Temperature>> allTemps = repository.getAllTemperatures();
        List<Temperature> flattened = allTemps.values().stream()
                .flatMap(List::stream)
                .toList();
        return new TemperatureResponse(flattened);
    }
}