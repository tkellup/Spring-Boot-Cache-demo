package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WeatherObservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private int id;

    @JsonProperty("longitude")
    private long longitude;

    @JsonProperty("latitude")
    private long latitude;

    @JsonProperty("windSpeed")
    private long windSpeed;

    @JsonProperty("windDirection")
    private long windDirection;

    @JsonProperty("airTemperature")
    private float airTemperature;

    @JsonProperty("eaLevelPressure")
    private float seaLevelPressure;

    public WeatherObservation() {
    }


    public WeatherObservation(int id, long longitude, long latitude, long windSpeed,
                              long windDirection, float airTemperature, float seaLevelPressure) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.airTemperature = airTemperature;
        this.seaLevelPressure = seaLevelPressure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(long windSpeed) {
        this.windSpeed = windSpeed;
    }

    public long getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(long windDirection) {
        this.windDirection = windDirection;
    }

    public float getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(float airTemperature) {
        this.airTemperature = airTemperature;
    }

    public float getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(float seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }
}

