package com.flight.daniel.flightapp.controller;

import com.flight.daniel.flightapp.model.User;
import com.flight.daniel.flightapp.security.JwtGenerator;
import com.flight.daniel.flightapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class TokenController {
    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private UserService userService;
    @PostMapping
    public String generate(@RequestBody final User user){
        if(userService.loginUser(user.getUserName(), user.getPassword())){
            user.setRole("ADMIN");
            return jwtGenerator.generate(user);
        }
        return null;
    }
}
