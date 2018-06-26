package com.iuminov.controller;

import com.iuminov.model.User;
import com.iuminov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements Controller {

    private  final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {

        User user = getUser(req);
        userService.createUser(user);

    }

    private User getUser(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String token = req.getParameter("token");

        return new User(firstName, lastName, email, password, token);
    }
}
