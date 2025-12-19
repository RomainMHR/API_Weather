package com.example.ubo.weatherapi.controller;

import com.example.ubo.weatherapi.business.WeatherBusiness;
import com.example.ubo.weatherapi.configuration.AuthenticationRequired;
import com.example.ubo.weatherapi.entity.WeatherEntity;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/weather")
public class WeatherController {

    private final WeatherBusiness weatherBusiness;

    public WeatherController(WeatherBusiness weatherBusiness) {
        this.weatherBusiness = weatherBusiness;
    }

    @GET
    @AuthenticationRequired
    @Path("/{cityID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeatherForCity(@PathParam("cityID") Integer cityID) {
        WeatherEntity weather = weatherBusiness.getWeatherForCity(cityID);
        return Response.ok(weather).build();
    }


}
