package com.smarttourism.repository;

import com.smarttourism.model.Temperature;
import lombok.Data;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Data
public class TemperatureRepository {
    private final Map<String, List<Temperature>> temperatureData = new ConcurrentHashMap<>();

    public void save(String city, Temperature temperature) {
        temperatureData.computeIfAbsent(city, k -> Collections.synchronizedList(new ArrayList<>()))
                .add(temperature);
    }

    public List<Temperature> getTemperatures(String city) {
        return temperatureData.getOrDefault(city, new ArrayList<>());
    }

    public Map<String, List<Temperature>> getAllTemperatures() {
        return new HashMap<>(temperatureData);
    }

    public void clear() {
        temperatureData.clear();
    }
}