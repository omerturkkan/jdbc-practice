package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import org.testng.Assert;
import utilities.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersUpdateStepDefinitions {

    @When("the user updates {string} to {string} in {string} table where {string} is {string}")
    public void the_user_updates_to_in_table_where_is(String column, String value, String table, String conditionColumn, String conditionValue) {
        String query = LoantechQueries.update(table, column, value, conditionColumn, conditionValue);
        DatabaseUtils.executeUpdate(query);
    }

    @Then("the {string} in {string} table where {string} is {string} should be {string}")
    public void the_in_table_where_is_should_be(String column, String table, String conditionColumn, String conditionValue, String expectedValue) throws SQLException {
        String selectQuery = "SELECT " + column + " FROM " + table + " WHERE " + conditionColumn + "='" + conditionValue + "'";
        ResultSet resultSet = DatabaseUtils.executeQuery(selectQuery);

        resultSet.first();

        String actualValue = resultSet.getString(column);

        Assert.assertEquals(actualValue, expectedValue);
    }
}