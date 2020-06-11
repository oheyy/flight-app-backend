package com.flight.daniel.flightapp.security;

import com.flight.daniel.flightapp.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    public String secret = "Graphql";
    public User validate(String token){
        User user = null;
        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            user = new User();
            user.setUserName(body.getSubject());
            user.setPassword((String) body.get("userId"));
            user.setRole((String) body.get("role"));
        }catch (Exception e){
            System.out.println(e);
        }


        return user;
    }
}
