package com.example.ubo.weatherapi.business;

import dto.clientapi.User;
import com.example.ubo.weatherapi.entity.ClientEntity;
import com.example.ubo.weatherapi.mapper.ClientMapper;
import com.example.ubo.weatherapi.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientBusiness {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    // Injection par constructeur (Meilleure pratique que @Autowired)
    public ClientBusiness(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public void createNewClient(User userDto) {
        // 1. Conversion DTO -> Entity via le Mapper
        ClientEntity clientEntity = clientMapper.toEntity(userDto);

        // 2. Sauvegarde en base via le Repository
        clientRepository.save(clientEntity);

        // (Optionnel) Ici tu pourrais envoyer un mail de bienvenue, etc.
    }
}