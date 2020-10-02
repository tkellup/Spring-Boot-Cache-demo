package com.example.springboot.cruddemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.WeatherObservation;

import java.util.List;

public interface WeatherObservationService {
    List<WeatherObservation> findAll() throws JsonProcessingException, InterruptedException;

    WeatherObservation findById(int id);

    List<Object> findAllObjects();

    void save(WeatherObservation e);

    void deleteById(int id);
}
