package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import org.testng.Assert;

import java.sql.*;

import static stepdefinitions.CommonStepDefinitions.*;

public class DepositsStepDefinitions {

    @When("the user queries amount values from the deposits table")
    public void the_user_queries_amount_values_from_the_deposits_table() throws SQLException {
        String query = LoantechQueries.GET_ALL_DEPOSIT_AMOUNTS;

        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        resultSet = statement.executeQuery(query);
    }

    @Then("there should be {int} records with amount between {int} and {int}")
    public void there_should_be_records_with_amount_between_and(int expectedCount, int min, int max) throws SQLException {
        int counter = 0;

        while (resultSet.next()) {
            int amount = resultSet.getInt("amount");
            if (amount >= min && amount <= max) {
                counter++;
            }
        }

        Assert.assertEquals(counter, expectedCount);
    }
}