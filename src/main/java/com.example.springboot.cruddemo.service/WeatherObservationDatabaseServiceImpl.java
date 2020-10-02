package com.example.springboot.cruddemo.service;

import model.WeatherObservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.WeatherObservationRepository;

import java.util.List;

@Service
public class WeatherObservationDatabaseServiceImpl implements WeatherObservationService {
    private WeatherObservationRepository weatherObservationRepository;

    @Autowired
    public WeatherObservationDatabaseServiceImpl(@Qualifier("weatherObservationDAOImpl") WeatherObservationRepository weatherObservationRepository) {
        this.weatherObservationRepository = weatherObservationRepository;
    }

    @Override
    public List<Object> findAllObjects() {
        return null;
    }

    @Override
    @Transactional
    public List<WeatherObservation> findAll() {
        return weatherObservationRepository.findAll();
    }

    @Override
    @Transactional
    public WeatherObservation findById(int id) {
        return weatherObservationRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(WeatherObservation e) {
        weatherObservationRepository.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        weatherObservationRepository.deleteById(id);
    }
}
