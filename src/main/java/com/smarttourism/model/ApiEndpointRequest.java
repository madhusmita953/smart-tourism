package com.smarttourism.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Base64;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiEndpointRequest {
    @JsonProperty("endpoint")
    private String endpoint;
    
    @JsonProperty("hostname")
    private String hostname;
    
    public String getEncodedHostname() {
        return Base64.getEncoder().encodeToString(hostname.getBytes());
    }
}