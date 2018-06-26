package com.iuminov;

import com.iuminov.controller.GetAllCategoriesController;
import com.iuminov.controller.GetCategoryById;
import com.iuminov.controller.LoginController;
import com.iuminov.controller.SignUpController;
import com.iuminov.dao.CategoryDao;
import com.iuminov.dao.CategoryDaoImpl;
import com.iuminov.dao.UserDao;
import com.iuminov.dao.UserDaoImpl;
import com.iuminov.model.Category;
import com.iuminov.service.CategoryService;
import com.iuminov.service.CategoryServiceImpl;
import com.iuminov.service.UserService;
import com.iuminov.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

    private static Connection connection;

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/java-apr-18",
                    "sa",
                    "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GetCategoryById getCategoryById() {
        return new GetCategoryById(getCategoryService());
    }

    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(getCategoryService());
    }

    public static UserDao getUserDaoImpl() {
        return new UserDaoImpl(connection);
    }

    public static SignUpController getSignUpController() {
        return new SignUpController(getUserService());
    }

    public static LoginController getLoginController() {
        return new LoginController(getUserService());
    }

    private static CategoryService getCategoryService() {
        return new CategoryServiceImpl(getCategoryDaoImpl());
    }

    private static CategoryDao getCategoryDaoImpl() {
        return new CategoryDaoImpl(connection);
    }

    private static UserService getUserService() {
        return new UserServiceImpl(getUserDaoImpl());
    }
}
