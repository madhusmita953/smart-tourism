package com.smarttourism.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tourist_place")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String city;
    private String placeName;
    private String description;
    private Double rating;
}
