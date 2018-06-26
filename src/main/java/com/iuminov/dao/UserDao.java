package com.iuminov.dao;

import com.iuminov.model.User;

public interface UserDao {

    User getByToken(String token);

    void createUser(User user);

    User getById(Long id);

    User getByEmail(String email);

    void update(User user);
}
