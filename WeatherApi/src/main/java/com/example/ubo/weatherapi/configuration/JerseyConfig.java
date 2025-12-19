package com.example.ubo.weatherapi.configuration;

import com.example.ubo.weatherapi.exception.FunctionnalException;
import com.example.ubo.weatherapi.handlers.FunctionnalExceptionHandler;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api/v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("com.example.ubo.weatherapi.controller");
        register(AuthenticationRequiredImpl.class);
        packages("com.example.ubo.weatherapi.configuration");
        register(FunctionnalException.class);
        packages("com.example.ubo.weatherapi.exception");
        packages("com.example.ubo.weatherapi.handlers");
        register(FunctionnalExceptionHandler.class);
    }
}
