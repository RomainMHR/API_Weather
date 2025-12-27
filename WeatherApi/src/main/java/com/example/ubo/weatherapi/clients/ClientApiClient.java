package com.example.ubo.weatherapi.clients;

import feign.RequestLine;
import feign.Response;

public interface ClientApiClient {
    @RequestLine("POST /client/validate")
    Response validateToken(String token);
}