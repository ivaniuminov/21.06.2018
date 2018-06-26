package com.iuminov.dao;

import com.iuminov.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    private final Connection connection;

    public UserDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getByToken(String token) {
        String query = "SELECT ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, TOKEN " +
                "FROM USERS WHERE TOKEN = ?";

        ResultSet resultSet = null;
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, token);
            resultSet = statement.executeQuery();

            if (resultSet.first()) {
                user = new User(
                  resultSet.getLong(1),
                  resultSet.getString(2),
                  resultSet.getString(3),
                  resultSet.getString(4),
                  resultSet.getString(5),
                  resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void createUser(User user) {
        String query = "INSERT INTO USERS (FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, TOKEN) " +
                "VALUES (?, ?, ?, ?, ?);";


        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getToken());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByEmail(String email) {
        String query = "SELECT ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, TOKEN " +
        "FROM USERS WHERE EMAIL = ?";

        ResultSet resultSet = null;
        User user = null;

        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.first()) {
                user = new User(
                        resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void update(User user) {
        String query = "UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PASSWORD = ?, TOKEN = ? "
                + "WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getToken());
            statement.setLong(6, user.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
