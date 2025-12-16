package com.example.ubo.weatherapi.business;

import com.example.ubo.weatherapi.entity.WeatherEntity;
import com.example.ubo.weatherapi.mapper.WeatherMapper;
import com.example.ubo.weatherapi.repository.CityRepository;
import com.example.ubo.weatherapi.repository.OpenWeatherRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class WeatherBusiness {

    @Inject
    private CityRepository cityRepository;

    @Inject
    private OpenWeatherRepository openweatherRepository;

    public WeatherEntity getWeatherForCity(Integer cityID) {
        var city = cityRepository.getCityById(String.valueOf(cityID));
        var weather = openweatherRepository.getOpenWeather(city.getName());

        WeatherEntity weatherEntity = new WeatherEntity();
        WeatherMapper weatherMapper = new WeatherMapper();

        weatherEntity = weatherMapper.toEntity(weather);
        weatherEntity.setCity(city);

        return weatherEntity;
    }

}

