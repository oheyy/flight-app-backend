package com.flight.daniel.flightapp.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.flight.daniel.flightapp.model.Flight;
import com.flight.daniel.flightapp.service.FlightService;
import com.flight.daniel.flightapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightQueryResolver implements GraphQLQueryResolver {
    @Autowired
    FlightService flightService;

    @Autowired
    UserService userService;

    public List<Flight> flight(String countryFrom, String countryTo){
        return flightService.searchFlights(countryFrom, countryTo);
    }

    public boolean searchUser(String userName, String password){
        return userService.searchUser(userName, password);
    }
}
