package com.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class AppTest {
    @Test
    public void testDatabaseConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mvn1";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            assertNotNull(connection);
        } catch (SQLException e) {
            fail("Database connection failed");
        }
    }
}
