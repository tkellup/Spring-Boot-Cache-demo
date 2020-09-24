package repo;

import model.WeatherObservation;

import java.util.List;

public interface WeatherObservationRepository {
    List<WeatherObservation> findAll();

    WeatherObservation findById(int id);

    void save(WeatherObservation e);

    void deleteById(int id);
}
