package com.flight.daniel.flightapp.controller;

import com.flight.daniel.flightapp.model.Flight;
import com.flight.daniel.flightapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "retrieve/all")
    public List<Flight> retrieveAllFlights(){
        return service.getAllFlights();
    }
}
