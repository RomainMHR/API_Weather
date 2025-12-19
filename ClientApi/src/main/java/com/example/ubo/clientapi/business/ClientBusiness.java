package com.example.ubo.clientapi.business;

import com.example.ubo.clientapi.entity.ClientEntity;
import com.example.ubo.clientapi.mapper.ClientMapper;
import com.example.ubo.clientapi.repository.ClientRepository;
import dto.clientapi.User;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

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

    /* public void signin(ClientEntity entity) {
        ClientEntity client = clientRepository.getClientByEmail(entity.getMail());
    } */
}