package ch05_dynamic_query;

import manage_queries.LoantechQueries;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NameTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://195.35.59.18/u201212290_qaloantec";
        String username = "u201212290_qaloanuser";
        String password = "HPo?+7r$";

        Connection connection = DriverManager.getConnection(url, username, password);

        String query = LoantechQueries.GET_ALL_FIRSTNAMES;

        Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        ResultSet resultSet = statement.executeQuery(query);

        List<String> firstnameList = new ArrayList<>();

        while (resultSet.next()) {
            firstnameList.add(resultSet.getString("firstname"));
        }

        if (firstnameList.contains("hasan")) {
            System.out.println("Firstname verification: PASSED");
        } else {
            System.out.println("Firstname verification: FAILED");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}