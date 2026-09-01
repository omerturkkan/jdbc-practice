package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

import static stepdefinitions.CommonStepDefinitions.*;

public class CronSchedulesStepDefinitions {

    @When("the user queries names from the cron_schedules table")
    public void the_user_queries_names_from_the_cron_schedules_table() throws SQLException {
        String query = LoantechQueries.GET_ALL_CRON_SCHEDULE_NAMES;

        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        resultSet = statement.executeQuery(query);
    }

    @Then("the first two names should be {string} and {string}")
    public void the_first_two_names_should_be_and(String expectedFirst, String expectedSecond) throws SQLException {
        resultSet.absolute(1);
        String actualFirst = resultSet.getString("name");
        Assert.assertEquals(actualFirst, expectedFirst);

        resultSet.absolute(2);
        String actualSecond = resultSet.getString("name");
        Assert.assertEquals(actualSecond, expectedSecond);
    }
}