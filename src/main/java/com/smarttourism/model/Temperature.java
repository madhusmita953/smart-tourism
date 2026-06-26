package com.smarttourism.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    @JsonProperty("city")
    private String city;
    
    @JsonProperty("temperature")
    private Double temperature;
    
    @JsonProperty("unit")
    private String unit;
}