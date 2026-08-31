package ch04_database_test;

import java.sql.*;

public class UsernameListQuery {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
        String username = "u201212290_qaloanuser";
        String password = "HPo?+7r$";

        Connection connection = DriverManager.getConnection(url, username, password);

        String query = "SELECT username FROM users";

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("username"));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}