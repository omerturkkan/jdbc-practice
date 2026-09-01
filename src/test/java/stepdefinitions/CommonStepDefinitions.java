package stepdefinitions;

import io.cucumber.java.en.*;
import utilities.ConfigReader;

import java.sql.*;

public class CommonStepDefinitions {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    @Given("the user connects to the database")
    public void the_user_connects_to_the_database() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("url"),
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    @Then("the user closes the database connection")
    public void the_user_closes_the_database_connection() throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}