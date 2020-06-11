package com.flight.daniel.flightapp.security;

import com.flight.daniel.flightapp.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(User user){
        Claims claims = Jwts.claims()
                .setSubject(user.getUserName());
        claims.put("password", String.valueOf(user.getPassword()));
        claims.put("role", user.getRole());
        return  Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "Graphql")
                .compact();
    }
}
