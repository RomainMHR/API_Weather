package com.example.ubo.weatherapi.clients;

import dto.openweather_swagger.Model200;
import feign.Param;
import feign.RequestLine;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public interface OpenWeatherClient {

    @RequestLine("GET /data/2.5/weather?q={city_name}&appid=8fdfcc7c10b55c00719e1113684dafe8&units=metric")
    Model200 getWeatherForCity(@Param("city_name") String cityName);

}
