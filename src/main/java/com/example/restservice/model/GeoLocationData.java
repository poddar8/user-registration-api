package com.example.restservice.model;

import lombok.Builder;
import lombok.Data;

@Data
public class GeoLocationData {

    String country;
    String city;
    String query;
}
