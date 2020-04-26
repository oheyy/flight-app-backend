package com.flight.daniel.flightapp.controller;

import com.flight.daniel.flightapp.model.Flight;
import com.flight.daniel.flightapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/flight")
public class FlightController {
    @Autowired
    FlightService service;

    @PostMapping(value = "/create")
    public String create(@RequestBody Flight flight){
        service.createFlight(flight);
        return "Flight record created";
    }
}
