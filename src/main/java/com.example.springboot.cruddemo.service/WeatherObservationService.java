package com.example.springboot.cruddemo.service;

import model.WeatherObservation;

import java.util.List;

public interface WeatherObservationService {
    List<WeatherObservation> findAll();
    WeatherObservation findById(int id);
    void save(WeatherObservation e);
    void deleteById(int id);
}
