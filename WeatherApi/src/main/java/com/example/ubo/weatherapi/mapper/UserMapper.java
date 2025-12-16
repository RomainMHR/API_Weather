package com.example.ubo.weatherapi.mapper;

import com.example.ubo.weatherapi.dto.UserDto;
import com.example.ubo.weatherapi.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    public static UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setUsername(entity.getUsername());
        // Note: We don't expose the password in the DTO for security reasons
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
