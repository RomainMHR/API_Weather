package com.example.ubo.clientapi.controller;

import com.example.ubo.clientapi.business.ClientBusiness;
import dto.clientapi.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

@Component
@Path("/client") // URL = /api/v1 (JerseyConfig) + /client
public class ClientController {

    private final ClientBusiness clientBusiness;

    public ClientController(ClientBusiness clientBusiness) {
        this.clientBusiness = clientBusiness;
    }

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response signup(User userDto) {
        clientBusiness.createNewClient(userDto);

        return Response.status(Response.Status.CREATED)
                .entity("Client créé avec succès")
                .build();
    }
}