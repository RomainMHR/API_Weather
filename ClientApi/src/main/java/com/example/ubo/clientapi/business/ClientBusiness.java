package com.example.ubo.clientapi.business;

import com.example.ubo.clientapi.entity.ClientEntity;
import com.example.ubo.clientapi.mapper.ClientMapper;
import com.example.ubo.clientapi.repository.ClientRepository;
import com.example.ubo.clientapi.utils.JwtUtils;
import dto.clientapi.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientBusiness {

    @Inject
    private ClientRepository clientRepository;

    @Inject
    private ClientMapper clientMapper;

    public void createNewClient(User userDto) {
        // 1. Conversion DTO -> Entity via le Mapper
        ClientEntity clientEntity = clientMapper.toEntity(userDto);

        // 2. Sauvegarde en base via le Repository
        clientRepository.save(clientEntity);
    }

    public Response signin(ClientEntity entity) {
        User user = clientRepository.getClientByEmail(entity.getMail());
        if (user != null && Objects.equals(user.getPassword(), entity.getPassword())) {
                var jwt =  JwtUtils.generateToken(user.getEmail());
                return Response.ok(jwt).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    public boolean isValidToken(String token) {
        try {
            JwtUtils.validateToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}