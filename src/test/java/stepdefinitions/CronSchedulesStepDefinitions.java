package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import utilities.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CronSchedulesStepDefinitions {

    @Then("record {int} should have name {string}")
    public void record_should_have_name(int rowNumber, String expectedName) throws SQLException {
        ResultSet resultSet = DatabaseUtils.getResultSet();

        resultSet.absolute(rowNumber);

        String actualName = resultSet.getString("name");

        Assert.assertEquals(actualName, expectedName);
    }
}