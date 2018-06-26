package com.iuminov.service;

import com.iuminov.model.User;

public interface UserService{

    void createUser(User user);

    User getById(Long id);

    User getByEmail(String email);

    User validateCredentials(String email, String password);
}
