package com.example.ubo.weatherapi.entity;

import dto.weatherapi.UnityEnum;
import dto.weatherapi.VisibilityEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import dto.weatherapi.City;

public class WeatherEntity {

    private Integer temperature;
    private BigDecimal humidity;
    private UnityEnum unity;
    private VisibilityEnum visibility;
    private City city;
    private LocalDate date;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public UnityEnum getUnity() {
        return unity;
    }

    public void setUnity(UnityEnum unity) {
        this.unity = unity;
    }

    public VisibilityEnum getVisibility() {
        return visibility;
    }

    public void setVisibility(VisibilityEnum visibility) {
        this.visibility = visibility;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}

