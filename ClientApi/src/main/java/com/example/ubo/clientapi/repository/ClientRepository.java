package com.example.ubo.clientapi.repository;

import com.example.ubo.clientapi.entity.ClientEntity;
import dto.clientapi.User;
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

    private final static String SQL_GET_CLIENT_BY_MAIL = "SELECT nom, prenom, mail, password FROM clients WHERE mail = :mail";

    public void save(ClientEntity client) {
        Map<String, Object> params = new HashMap<>();
        params.put("nom", client.getNom());
        params.put("prenom", client.getPrenom());
        params.put("mail", client.getMail());
        params.put("password", client.getPassword());

        jdbcTemplate.update(SQL_INSERT, params);
    }

    public User getClientByEmail(String mail) {
        Map<String, Object> params = new HashMap<>();
        params.put("mail", mail);
        return jdbcTemplate.queryForObject(SQL_GET_CLIENT_BY_MAIL, params, (rs, rowNum) -> {
            User user = new User();
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setEmail(rs.getString("mail"));
            user.setPassword(rs.getString("password"));
            return user;
        });
    }
}