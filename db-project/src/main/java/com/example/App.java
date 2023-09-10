package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mvn1";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT * FROM t1";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
