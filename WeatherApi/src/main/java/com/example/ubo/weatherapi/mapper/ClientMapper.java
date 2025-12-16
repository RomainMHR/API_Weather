package com.example.ubo.weatherapi.mapper;

import dto.clientapi.User;
import com.example.ubo.weatherapi.entity.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    // Transforme le DTO (User) en Entité (ClientEntity)
    public ClientEntity toEntity(User userDto) {
        if (userDto == null) {
            return null;
        }

        return new ClientEntity(
                userDto.getNom(),
                userDto.getPrenom(),
                userDto.getEmail(), // Attention au nom du champ dans le DTO (email vs mail)
                userDto.getPassword()
        );
    }

    // Si tu as besoin de faire l'inverse plus tard :
    // public User toDto(ClientEntity entity) { ... }
}