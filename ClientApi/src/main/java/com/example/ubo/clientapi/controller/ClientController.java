package com.example.ubo.clientapi.controller;

import com.example.ubo.clientapi.business.ClientBusiness;
import dto.clientapi.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;
import com.example.ubo.clientapi.mapper.ClientMapper;

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

    @POST
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response signin(User user){
        return this.clientBusiness.signin(ClientMapper.toEntity(user));
    }

    @POST
    @Path("/validate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateToken(String token) {
        String cleanToken = token.replace("\"", "").trim();

        if (clientBusiness.isValidToken(cleanToken)) {
            return Response.ok().build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}