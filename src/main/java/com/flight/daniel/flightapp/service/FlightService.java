package com.flight.daniel.flightapp.service;

import com.flight.daniel.flightapp.model.Flight;

import java.util.List;

public interface FlightService {
    public void createFlight(Flight flight);
    public List<Flight>getAllFlights();
}
