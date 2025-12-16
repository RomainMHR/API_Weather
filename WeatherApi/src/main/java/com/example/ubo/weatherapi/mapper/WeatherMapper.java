package com.example.ubo.weatherapi.mapper;

import com.example.ubo.weatherapi.entity.WeatherEntity;
import com.example.ubo.weatherapi.repository.CityRepository;
import dto.openweather_swagger.Model200;
import dto.weatherapi.UnityEnum;
import dto.weatherapi.VisibilityEnum;
import dto.weatherapi.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;

public class WeatherMapper {

    public static Weather toDto(final WeatherEntity entity) {
        Weather dto = new Weather();
        dto.setTemperature(entity.getTemperature().floatValue());
        dto.setHumidity(entity.getHumidity().floatValue());
        dto.setUnity(entity.getUnity());
        dto.setVisibility(entity.getVisibility());
        dto.setCity(entity.getCity());
        dto.setDate(entity.getDate());
        return dto;
    }

    public static WeatherEntity toEntity(final Model200 dto) {
        WeatherEntity entity = new WeatherEntity();
        entity.setTemperature(dto.getMain().getTemp().intValue());
        entity.setHumidity(BigDecimal.valueOf(dto.getMain().getHumidity()));
        entity.setUnity(UnityEnum.CELSIUS);
        entity.setVisibility(VisibilityMapper.fromOpenWeather(dto.getVisibility()));
        //entity.setCity();
        entity.setDate(Instant.ofEpochSecond(dto.getDt())
                .atZone(ZoneId.systemDefault())
                .toLocalDate());
        return entity;
    }
}
