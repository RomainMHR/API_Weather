package com.example.ubo.clientapi.mapper;

import com.example.ubo.clientapi.entity.ClientEntity;
import dto.clientapi.User;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    // Transforme le DTO (User) en Entité (ClientEntity)
    public static ClientEntity toEntity(User userDto) {
        if (userDto == null) {
            return null;
        }

        return new ClientEntity(
                userDto.getNom(),
                userDto.getPrenom(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}