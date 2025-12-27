package com.example.ubo.weatherapi.configuration;

import com.example.ubo.weatherapi.clients.ClientApiClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@AuthenticationRequired
@Provider
public class AuthenticationRequiredImpl implements ContainerRequestFilter {

    @Inject
    private ClientApiClient clientApiClient;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authHeader = containerRequestContext.getHeaderString("Authentication");

        if (authHeader == null || authHeader.isEmpty()) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Token manquant").build());
            return;
        }

        String token = authHeader.replace("Bearer ", "").trim();

        try (feign.Response feignResponse = clientApiClient.validateToken(token)) {

            if (feignResponse.status() != 200) {
                containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Token invalide").build());
            }

        } catch (Exception e) {
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Validation impossible").build());
        }
    }
}