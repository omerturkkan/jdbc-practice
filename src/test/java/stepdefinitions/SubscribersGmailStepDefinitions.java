package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import utilities.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscribersGmailStepDefinitions {

    @Then("the gmail count should be more than {int}")
    public void the_gmail_count_should_be_more_than(int expectedMin) throws SQLException {
        ResultSet resultSet = DatabaseUtils.getResultSet();
        int counter = 0;

        while (resultSet.next()) {
            if (resultSet.getString("email").contains("@gmail.com")) {
                counter++;
            }
        }

        Assert.assertTrue(counter > expectedMin,
                "Expected more than " + expectedMin + " gmail records, but found " + counter);
    }
}