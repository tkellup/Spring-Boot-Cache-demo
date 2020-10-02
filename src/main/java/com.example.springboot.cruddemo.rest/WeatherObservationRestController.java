package com.example.springboot.cruddemo.rest;

import com.example.springboot.cruddemo.service.WeatherObservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import model.WeatherObservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherObservationRestController {
    private final WeatherObservationService weatherObservationService;

    @Autowired
    public WeatherObservationRestController(WeatherObservationService weatherObservationService) {
        this.weatherObservationService = weatherObservationService;
    }

    @GetMapping("/weatherObservations")
    public List<WeatherObservation> getAllWeatherObservation() throws JsonProcessingException, InterruptedException {
        return weatherObservationService.findAll();
    }

    @GetMapping("/weatherObservations/{weatherObservationId}")
    public WeatherObservation getWeatherObservations(@PathVariable("weatherObservationId") int id) {
        WeatherObservation weatherObservation = weatherObservationService.findById(id);

        if (weatherObservation == null) {
            throw new RuntimeException("Employee not found.");
        }
        return weatherObservation;
    }

    @PostMapping
    public WeatherObservation saveEmployee(WeatherObservation w) {
        //also just in case they pass an id in JSON...
        //set id to 0; this will force a save of new item
        //instead of update
        w.setId(0);
        weatherObservationService.save(w);
        return w;
    }

    @PutMapping("/weatherObservations")
    public WeatherObservation update(@RequestBody WeatherObservation w) {
        weatherObservationService.save(w);
        return w;
    }

    @DeleteMapping("/weatherObservations/{weatherObservationId}")
    public String deleteById(@PathVariable("weatherObservationId") int id) {
        WeatherObservation e = weatherObservationService.findById(id);

        if (e == null) {
            throw new RuntimeException("Employee not found - " + id);
        }
        weatherObservationService.deleteById(id);
        return "Deleted id - " + id;
    }
}
