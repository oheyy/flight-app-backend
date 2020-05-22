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

    @Autowired
    SequenceIdService sequenceIdService;

    @Override
    public Flight createFlight(Flight flight) {
        try {
            flight.setId(sequenceIdService.getNextSequenceId("flight"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        flightDao.save(flight);
        return flight;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.findAll();
    }

    @Override
    public List<Flight> searchFlights(String countryFrom, String countryTo){
        return flightDao.searchFlights(countryFrom, countryTo);
    }


}
