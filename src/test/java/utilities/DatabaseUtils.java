package utilities;

import java.sql.*;

public final class DatabaseUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    private DatabaseUtils() { }

    public static Connection getConnection() {
        String url = ConfigReader.getProperty("url");
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static Statement createStatement() {
        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    public static int executeUpdate(String query) {
        createStatement();
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void closeConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement createPreparedStatement(String query) {
        try {
            preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preparedStatement;
    }
}