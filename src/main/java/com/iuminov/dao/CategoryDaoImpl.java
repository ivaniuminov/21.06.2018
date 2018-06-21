package com.iuminov.dao;

import com.iuminov.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

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

    @Override
    public List<Category> getAll() {
        List<Category> result = new ArrayList<>();
        String query = "SELECT ID, CATEGORY_NAME, DESCRIPTION FROM CATEGORIES";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()) {
                result.add(new Category(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                        null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
