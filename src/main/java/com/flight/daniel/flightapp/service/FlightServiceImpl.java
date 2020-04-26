package com.flight.daniel.flightapp.service;

import com.flight.daniel.flightapp.dao.FlightDao;
import com.flight.daniel.flightapp.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightDao flightDao;


    @Override
    public void createFlight(Flight flight) {
        flightDao.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.findAll();
    }
}
