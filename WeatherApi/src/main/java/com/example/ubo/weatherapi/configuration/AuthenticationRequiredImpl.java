package com.example.ubo.weatherapi.configuration;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@AuthenticationRequired
@Provider
public class AuthenticationRequiredImpl implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if(containerRequestContext.getHeaders().containsKey("Authentication"))
            return;
        containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }
}
