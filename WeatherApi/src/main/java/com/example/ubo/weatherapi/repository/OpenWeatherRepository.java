package com.example.ubo.weatherapi.repository;

import com.example.ubo.weatherapi.clients.OpenWeatherClient;
import dto.openweather_swagger.Model200;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.rmi.MarshalledObject;

@Component
public class OpenWeatherRepository {

    @Inject
    private OpenWeatherClient openWeatherClient;

    public Model200 getOpenWeather(String cityName){
        return openWeatherClient.getWeatherForCity(cityName);
    }
}
