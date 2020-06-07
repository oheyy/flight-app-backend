package com.flight.daniel.flightapp.service;

import com.flight.daniel.flightapp.dao.UserDao;
import com.flight.daniel.flightapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean searchUser(String username, String password) {
        boolean matched = false;
        List<User> users = userDao.searchUser(username);
        return users.stream()
                .anyMatch(user ->
                {
                    return bCryptPasswordEncoder.matches(password, user.getPassword());
                }
                );
    }
}
