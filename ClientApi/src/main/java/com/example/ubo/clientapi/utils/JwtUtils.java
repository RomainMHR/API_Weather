package com.example.ubo.clientapi.utils;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtils {
    private static final SecretKey secretKey = Jwts.SIG.HS256.key().build();

    public static String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .claims()
                .add("email", email)
                .add("signedBy", "client-api")
                .and()
                .signWith(secretKey)
                .compact();
    }
}
