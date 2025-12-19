package com.example.ubo.weatherapi.handlers;

import com.example.ubo.weatherapi.exception.FunctionnalException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import dto.weatherapi.Error;

public class FunctionnalExceptionHandler implements ExceptionMapper<FunctionnalException> {
    @Override
    public Response toResponse(FunctionnalException exception) {
        Error error = new Error();
        error.setCode(exception.getCode());
        error.setMessage(exception.getDescription());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
