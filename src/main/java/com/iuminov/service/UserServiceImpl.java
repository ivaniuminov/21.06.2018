package com.iuminov.service;

import com.iuminov.dao.UserDao;
import com.iuminov.model.User;

import java.util.Objects;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setToken(generateToken());
        userDao.createUser(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User validateCredentials(String email, String password) {
        User user = getByEmail(email);
        String hashedPassword = hashPassword(password);

        if (user != null && user.getPassword().equals(hashedPassword)) {
            user.setToken(generateToken());
            userDao.update(user);
        } else {
            user = null;
        }

        return user;
    }


    private String hashPassword(String password) {
        return String.valueOf(Objects.hash(password));
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
