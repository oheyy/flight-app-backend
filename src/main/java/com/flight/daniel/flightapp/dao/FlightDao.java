package com.flight.daniel.flightapp.dao;

import com.flight.daniel.flightapp.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDao extends MongoRepository<Flight, Integer> {
    @Query("{'countryFrom': ?0, 'countryTo': ?1}")
    public List<Flight> searchFlights(String countryFrom, String countryTo);
}
