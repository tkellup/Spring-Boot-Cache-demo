package com.example.springboot.cruddemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.WeatherObservation;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Primary
@Service
public class WeatherObservationCachingServiceImpl implements WeatherObservationService {
    private RestTemplate restTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    public WeatherObservationCachingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("weatherObservation")
    @Override
    public List<WeatherObservation> findAll() throws JsonProcessingException, InterruptedException {
        List<WeatherObservation> result = new ArrayList<>();
        Thread.sleep(4000);
        String url = "http://localhost:8080/api/weatherObservationsData";
//        HttpHeaders header = new HttpHeaders();
//        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<WeatherObservation[]> response = restTemplate.getForEntity(url, WeatherObservation[].class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            for (WeatherObservation wo : response.getBody()) {
                result.add(new WeatherObservation(wo.getId(), wo.getLongitude(), wo.getLatitude(),
                        wo.getWindSpeed(), wo.getWindDirection(), wo.getAirTemperature(),
                        wo.getSeaLevelPressure()));
            }
        } else {
            System.out.println("Error");
        }
        return result;
    }

    @Cacheable(cacheNames = "countries")
    @Override
    public List<Object> findAllObjects() {
        String url = "https://restcountries.eu/rest/v2/all";
        Object[] countries = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(countries);
    }

    @Cacheable(value = "weatherObservation", key = "#id")
    @Override
    public WeatherObservation findById(int id) {
//        List<WeatherObservation> result = Arrays.asList(new WeatherObservation(1, 15L, 13L, 75L,
//                        30L, 32.0f, 45.0f),
//                new WeatherObservation(2, 12L, 98L, 50L,
//                        300L, 132.0f, 445.0f));
//        return result.stream().filter(t -> t.getId() == id).findFirst().get();
        WeatherObservation wo = null;
        String url = "https://restcountries.eu/rest/v2/all";
        String result = restTemplate.getForObject(url, String.class);
        try {
            wo = mapper.readValue(result, WeatherObservation.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wo;
    }

    @Override
    @CachePut(value = "weatherObservation", key = "#wo.id")
    public void save(WeatherObservation wo) {
//        repo.save(e);
    }

    @Override
    @CacheEvict(value = "weatherObservation", key = "#id")
    public void deleteById(int id) {
//        repo.deleteById(id);
    }
}
