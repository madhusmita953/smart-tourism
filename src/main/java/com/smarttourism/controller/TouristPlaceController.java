package com.smarttourism.controller;

import com.smarttourism.model.TouristPlace;
import com.smarttourism.service.TouristPlaceService;
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
public class TouristPlaceController {
    private final TouristPlaceService touristPlaceService;

    @GetMapping("/tourist-places")
    public ResponseEntity<List<TouristPlace>> getAllTouristPlaces() {
        log.info("GET request: Fetch all tourist places");
        return ResponseEntity.ok(touristPlaceService.getAllPlaces());
    }

    @PostMapping("/select-tour/{id}")
    public ResponseEntity<TouristPlace> selectTour(@PathVariable Long id) {
        log.info("POST request: Select tour with id: {}", id);
        return touristPlaceService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tourist-places/{city}")
    public ResponseEntity<List<TouristPlace>> getTouristPlacesByCity(@PathVariable String city) {
        log.info("GET request: Fetch tourist places for city: {}", city);
        List<TouristPlace> places = touristPlaceService.getPlacesByCity(city);
        if (places.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(places);
    }

    @PostMapping("/register-place")
    public ResponseEntity<TouristPlace> registerTouristPlace(@RequestBody TouristPlace place) {
        log.info("POST request: Register new tourist place: {}", place.getPlaceName());
        TouristPlace saved = touristPlaceService.registerPlace(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}