package com.example.springboot.cruddemo.service;

import model.WeatherObservation;
import org.springframework.stereotype.Service;
import repo.WeatherObservationRepository;

import java.util.List;

@Service
public class WeatherObservationCachingServiceImpl implements WeatherObservationService{
    private WeatherObservationRepository repo;

    public WeatherObservationCachingServiceImpl(WeatherObservationRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<WeatherObservation> findAll() {
        return repo.findAll();
    }

    @Override
    public WeatherObservation findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void save(WeatherObservation e) {
        repo.save(e);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
