package com.example.ubo.weatherapi.mapper;

import com.example.ubo.weatherapi.entity.CityEntity;
import dto.weatherapi.City;
import dto.weatherapi.Position;

import java.math.BigDecimal;

public class CityMapper {

    public static City toDto(final CityEntity entity){
        var dto = new City();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountry(entity.getCountry());
        dto.setRegion(entity.getRegion());
        dto.setDepartement(entity.getDepartment());
        dto.setAltitude(BigDecimal.valueOf(Long.parseLong(entity.getAltitude())));
        var position = new Position();
        position.setLatitude(entity.getPosition().getLatitude());
        position.setLongitude(entity.getPosition().getLongitude());
        dto.setPosition(position);
        dto.setZipcode(BigDecimal.valueOf(Long.parseLong(entity.getZipCode())));
        return dto;
    }

    public static CityEntity toEntity(final City dto){
        var entity = new CityEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        entity.setRegion(dto.getRegion());
        entity.setDepartment(dto.getDepartement());
        entity.setAltitude(String.valueOf(dto.getAltitude()));
        var position = new Position();
        position.setLongitude(dto.getPosition().getLongitude());
        position.setLatitude(dto.getPosition().getLatitude());
        entity.setPosition(position);
        entity.setZipCode(String.valueOf(dto.getZipcode()));
        return entity;
    }
}

