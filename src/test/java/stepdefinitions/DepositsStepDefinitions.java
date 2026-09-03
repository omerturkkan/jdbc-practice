package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import utilities.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepositsStepDefinitions {

    @Then("there should be {int} records with amount between {int} and {int}")
    public void there_should_be_records_with_amount_between_and(int expectedCount, int min, int max) throws SQLException {
        ResultSet resultSet = DatabaseUtils.getResultSet();
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