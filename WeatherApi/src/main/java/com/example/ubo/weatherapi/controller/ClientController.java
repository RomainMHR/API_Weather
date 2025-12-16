package com.example.ubo.weatherapi.controller;

import dto.clientapi.User;
import com.example.ubo.weatherapi.business.ClientBusiness;
import org.springframework.stereotype.Component;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("/client") // L'URL sera /api/v1 (JerseyConfig) + /client
public class ClientController {

    private final ClientBusiness clientBusiness;

    public ClientController(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON) // On accepte du JSON
    @Produces(MediaType.TEXT_PLAIN)       // On renvoie du texte
    public Response signup(User userDto) {
        // Appel de la couche Business
        clientBusiness.createNewClient(userDto);

        // Réponse type JAX-RS (équivalent à ResponseEntity)
        return Response.status(Response.Status.CREATED)
                .entity("Client créé avec succès")
                .build();
    }
}