package com.example.ubo.weatherapi.business;

import com.example.ubo.weatherapi.entity.CityEntity;
import com.example.ubo.weatherapi.repository.CityRepository;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import static com.example.ubo.weatherapi.mapper.CityMapper.toDto;
import static com.example.ubo.weatherapi.mapper.CityMapper.toEntity;
@Service
public class CityBusiness {

    @Inject
    private CityRepository cityRepository;

    public void createCity(CityEntity city) {
        cityRepository.addCity(toDto(city));
    }

    public CityEntity getCityById(String id) {
        City city = cityRepository.getCityById(String.valueOf(id));
        return toEntity(city);
    }
}
