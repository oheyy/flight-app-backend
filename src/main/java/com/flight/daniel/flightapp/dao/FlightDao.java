package com.flight.daniel.flightapp.dao;

import com.flight.daniel.flightapp.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends MongoRepository<Flight, Integer> {

}
