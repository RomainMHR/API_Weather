package com.example.ubo.weatherapi.configuration;

import com.example.ubo.weatherapi.clients.ClientApiClient;
import com.example.ubo.weatherapi.clients.OpenWeatherClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
// Client HTTP
public class FeignConfig {

    private okhttp3.OkHttpClient getOkHttpClient() {
        var okHttpClient = new okhttp3.OkHttpClient.Builder();
        okHttpClient.connectTimeout(10000, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(10000, TimeUnit.MILLISECONDS);
        return okHttpClient.build();
    }

    @Inject
    private ObjectMapper objectMapper;

    // Paramètres de connexion à l'API OpenWeather
    @Bean
    public OpenWeatherClient getOpenWeatherClient(){
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .client(new OkHttpClient(getOkHttpClient()))
                .logger(new Logger.JavaLogger(FeignConfig.class))
                .logLevel(Logger.Level.FULL)
                .target(OpenWeatherClient.class, "https://api.openweathermap.org/");
    }

    // Paramètres de connexion à l'API Client
    @Bean
    public ClientApiClient getClientApiClient() {
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .client(new OkHttpClient(getOkHttpClient()))
                .logger(new Logger.JavaLogger(FeignConfig.class))
                .logLevel(Logger.Level.FULL)
                .target(ClientApiClient.class, "http://localhost:8000/api/v1");
    }
}
