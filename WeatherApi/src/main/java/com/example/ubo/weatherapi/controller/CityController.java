package com.example.ubo.weatherapi.controller;

import com.example.ubo.weatherapi.business.CityBusiness;
import com.example.ubo.weatherapi.configuration.AuthenticationRequired;
import com.example.ubo.weatherapi.entity.CityEntity;
import dto.weatherapi.City;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import static com.example.ubo.weatherapi.mapper.CityMapper.toDto;
import static com.example.ubo.weatherapi.mapper.CityMapper.toEntity;

@Controller
@Path("/city")
public class CityController {

    private final CityBusiness cityBusiness;

    public CityController(CityBusiness cityBusiness) {
        this.cityBusiness = cityBusiness;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCity(City city) {
        this.cityBusiness.createCity(toEntity(city));
        return Response.ok(city).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCityById(@PathParam("id") String id) {
        CityEntity cityEntity = this.cityBusiness.getCityById(id);
        return Response.ok(toDto(cityEntity)).build();
    }
}
