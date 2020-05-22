package com.flight.daniel.flightapp.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.flight.daniel.flightapp.model.Flight;
import com.flight.daniel.flightapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightQueryResolver implements GraphQLQueryResolver {
    @Autowired
    FlightService flightService;

    public Flight flight(String countryFrom, String countryTo){
        return flightService.searchFlights(countryFrom, countryTo).get(0);
    }
}