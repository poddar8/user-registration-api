package com.example.restservice;

import java.util.Arrays;

import com.example.restservice.model.GeoLocationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserAccountService {

    @Autowired
    RestTemplate restTemplate;


    public GeoLocationData getGeoLocation(String ipAddress) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(
                "http://ip-api.com/json/" + ipAddress, HttpMethod.GET, entity, GeoLocationData.class).getBody();
    }


}
