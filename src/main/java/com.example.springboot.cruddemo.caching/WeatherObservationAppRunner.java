package com.example.springboot.cruddemo.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import repo.WeatherObservationRepository;

public class WeatherObservationAppRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(WeatherObservationAppRunner.class);

    private final WeatherObservationRepository weatherObservationRepository;

    public WeatherObservationAppRunner(@Qualifier("SimpleWeatherObservationRepository") WeatherObservationRepository weatherObservationRepository) {
        this.weatherObservationRepository = weatherObservationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("...fetching weather observation data");
        logger.info("weather observation-10 " + weatherObservationRepository.findById(10));
        logger.info("weather observation-20 " + weatherObservationRepository.findById(20));
        logger.info("weather observation-30 " + weatherObservationRepository.findById(30));
        logger.info("weather observation-40 " + weatherObservationRepository.findById(40));
        logger.info("weather observation-50 " + weatherObservationRepository.findById(50));

    }
}
