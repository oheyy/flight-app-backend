package com.flight.daniel.flightapp.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.flight.daniel.flightapp.model.Flight;
import com.flight.daniel.flightapp.model.User;
import com.flight.daniel.flightapp.service.FlightService;
import com.flight.daniel.flightapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private FlightService flightService;

    @Autowired
    private UserService userService;

    public Flight createFlight(Flight flight){
        return flightService.createFlight(flight);
    }

    public User createUser(User user){
        return userService.createUser(user);
    }
}
