package com.example.springboot.cruddemo.caching;

import model.WeatherObservation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import repo.WeatherObservationRepository;

import java.util.List;

@Component
public class SimpleWeatherObservationRepository implements WeatherObservationRepository {
    @Override
    public List<WeatherObservation> findAll() {
        return null;
    }

    @Override
    @Cacheable("weather observation")
    public WeatherObservation findById(int id) {
        return new WeatherObservation(id, 0L, 0L, 0L,
                0L, 0.0f, 0.0f);
    }

    @Override
    public void save(WeatherObservation e) {

    }

    @Override
    public void deleteById(int id) {

    }
}
