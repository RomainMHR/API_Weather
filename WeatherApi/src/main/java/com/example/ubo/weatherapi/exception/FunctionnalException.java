package com.example.ubo.weatherapi.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class FunctionnalException extends RuntimeException {
    private int code;
    private String description;

    public FunctionnalException(int code, String description){
        super();
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
