package com.example.springboot.cruddemo.rest;

import com.example.springboot.cruddemo.service.WeatherObservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import model.WeatherObservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi")
public class WeatherObservationRestController2 {

    private WeatherObservationService service;

    public WeatherObservationRestController2(WeatherObservationService service) {
        this.service = service;
    }

    @GetMapping("/weatherObservationsData")
    public List<WeatherObservation> getAllWeatherObservationData() throws JsonProcessingException, InterruptedException {
        return service.findAll();
    }

    @GetMapping("/weatherObservationsData/{weatherObservationId}")
    public WeatherObservation getWeatherObservation(@PathVariable("weatherObservationId") int id) {
        return service.findById(id);
    }

    @GetMapping("/countries")
    public List<Object> getCountryData() throws JsonProcessingException, InterruptedException {
        return service.findAllObjects();
    }
}
