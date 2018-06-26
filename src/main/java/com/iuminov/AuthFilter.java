package com.iuminov;

import com.iuminov.dao.UserDao;
import com.iuminov.dao.UserDaoImpl;
import com.iuminov.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.FaultAction;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class AuthFilter implements Filter {

    private UserDao userDao;
    private final String COOKIES_NAME = "MyApp";
    private final Set<String> unprotectedUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.userDao = Factory.getUserDaoImpl();

        unprotectedUrls.add("/servlet/home");
        unprotectedUrls.add("/servlet/login");
        unprotectedUrls.add("/servlet/signup");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        Cookie[] cookies = req.getCookies();
        User user = null;

        for (Cookie c : cookies) {
            if (c.getName().equals(COOKIES_NAME)) {
                user = userDao.getByToken(c.getValue());
                break;
            }
        }

        if (user != null) {
            req.setAttribute("userId", user.getId());
            filterChain.doFilter(req, servletResponse);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
