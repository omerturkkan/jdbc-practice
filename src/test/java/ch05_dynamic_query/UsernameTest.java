package ch05_dynamic_query;

import manage_queries.LoantechQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsernameTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
        String username = "u201212290_qaloanuser";
        String password = "HPo?+7r$";

        Connection connection = DriverManager.getConnection(url, username, password);

        String query = LoantechQueries.GET_ALL_USERNAMES;

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        ResultSet resultSet = statement.executeQuery(query);

        List<String> usernameList = new ArrayList<>();

        while (resultSet.next()) {
            usernameList.add(resultSet.getString("username"));
        }

        System.out.println(usernameList);

        if (usernameList.contains("darkdark") && usernameList.contains("tester")) {
            System.out.println("Username verification: PASSED");
        } else {
            System.out.println("Username verification: FAILED");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}