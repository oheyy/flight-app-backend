package com.flight.daniel.flightapp.dao;

import com.flight.daniel.flightapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserDao extends MongoRepository<User, Integer> {
    @Query("{'userName': ?0}")
    public List<User> searchUser(String userName);
}
