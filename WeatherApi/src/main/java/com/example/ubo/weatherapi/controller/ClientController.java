package com.example.ubo.weatherapi.controller;

import dto.clientapi.User;
import com.example.ubo.weatherapi.business.ClientBusiness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientBusiness clientBusiness;

    public ClientController(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User userDto) {
        // Appel de la couche Business
        clientBusiness.createNewClient(userDto);

        return new ResponseEntity<>("Client créé avec succès", HttpStatus.CREATED);
    }
}