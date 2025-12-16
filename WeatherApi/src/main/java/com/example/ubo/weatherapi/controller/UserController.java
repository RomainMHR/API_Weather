package com.example.ubo.weatherapi.controller;

import com.example.ubo.weatherapi.business.UserBusiness;
import com.example.ubo.weatherapi.dto.UserDto;
import com.example.ubo.weatherapi.entity.UserEntity;
import com.example.ubo.weatherapi.mapper.UserMapper;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Path("/users")
public class UserController {

    private final UserBusiness userBusiness;

    public UserController(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(UserDto userDto) {
        UserEntity userEntity = UserMapper.toEntity(userDto);
        UserEntity registeredUser = userBusiness.registerUser(userEntity);
        return Response.ok(UserMapper.toDto(registeredUser)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<UserDto> users = userBusiness.getAllUsers().stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
        return Response.ok(users).build();
    }
}
