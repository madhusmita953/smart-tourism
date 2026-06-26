package com.smarttourism.repository;

import com.smarttourism.model.TouristPlace;
import lombok.Data;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Data
public class TouristPlaceRepository {
    private final List<TouristPlace> touristPlaces = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong idCounter = new AtomicLong(1);

    public TouristPlace save(TouristPlace place) {
        if (place.getId() == null) {
            place.setId(idCounter.getAndIncrement());
        }
        touristPlaces.add(place);
        return place;
    }

    public List<TouristPlace> findAll() {
        return new ArrayList<>(touristPlaces);
    }

    public Optional<TouristPlace> findById(Long id) {
        return touristPlaces.stream()
                .filter(place -> place.getId().equals(id))
                .findFirst();
    }

    public List<TouristPlace> findByCity(String city) {
        return touristPlaces.stream()
                .filter(place -> place.getCity().equalsIgnoreCase(city))
                .toList();
    }

    public void clear() {
        touristPlaces.clear();
    }
}