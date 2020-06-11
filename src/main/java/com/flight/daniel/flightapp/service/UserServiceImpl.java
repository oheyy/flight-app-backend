package com.flight.daniel.flightapp.service;

import com.flight.daniel.flightapp.dao.UserDao;
import com.flight.daniel.flightapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private SequenceIdService sequenceIdService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(User user) {
        try {
            user.setId(sequenceIdService.getNextSequenceId("user"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return user;
    }

    @Override
    public String searchUser(String username, String password) {
        String token = null;
        List<User> users = userDao.searchUser(username);
        Optional<User> foundUser = users.stream().filter(user -> bCryptPasswordEncoder.matches(password, user.getPassword())).findFirst();
        if(foundUser.isPresent()){
            token = foundUser.get().getPassword();
        }
        return token;
    }

    @Override
    public boolean loginUser(String username, String password) {
        List<User> usersFound = userDao.searchUser(username);

        return usersFound.stream().anyMatch(user -> bCryptPasswordEncoder.matches(password, user.getPassword()));
    }
}
