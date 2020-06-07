package com.flight.daniel.flightapp.service;

import com.flight.daniel.flightapp.model.User;

public interface UserService {
    public User createUser(User user);
    public boolean searchUser(String username, String password);
}
