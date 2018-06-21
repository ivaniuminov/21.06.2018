package com.iuminov.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    void process(HttpServletRequest req, HttpServletResponse resp);
}
