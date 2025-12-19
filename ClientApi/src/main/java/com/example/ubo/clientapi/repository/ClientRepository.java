package com.example.ubo.clientapi.repository;

import com.example.ubo.clientapi.entity.ClientEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ClientRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ClientRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String SQL_INSERT = "INSERT INTO clients (nom, prenom, mail, password) " +
            "VALUES (:nom, :prenom, :mail, :password)";

    public void save(ClientEntity client) {
        Map<String, Object> params = new HashMap<>();
        params.put("nom", client.getNom());
        params.put("prenom", client.getPrenom());
        params.put("mail", client.getMail());
        params.put("password", client.getPassword());

        jdbcTemplate.update(SQL_INSERT, params);
    }

}