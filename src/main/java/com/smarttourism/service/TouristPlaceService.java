package com.smarttourism.service;

import com.smarttourism.model.TouristPlace;
import com.smarttourism.repository.TouristPlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TouristPlaceService {
    private final TouristPlaceRepository repository;

    public TouristPlace registerPlace(TouristPlace place) {
        log.info("Registering tourist place: {} in city: {}", place.getPlaceName(), place.getCity());
        return repository.save(place);
    }

    public List<TouristPlace> getAllPlaces() {
        log.info("Fetching all tourist places");
        return repository.findAll();
    }

    public Optional<TouristPlace> getPlaceById(Long id) {
        log.info("Fetching tourist place with id: {}", id);
        return repository.findById(id);
    }

    public List<TouristPlace> getPlacesByCity(String city) {
        log.info("Fetching tourist places for city: {}", city);
        return repository.findByCity(city);
    }
}