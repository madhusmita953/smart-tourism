package com.smarttourism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristPlace {
    private Long id;
    private String city;
    private String placeName;
    private String description;
    private Double rating;
}