package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import org.testng.Assert;
import utilities.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaucedemoStepDefinitions {

    @When("the user queries the username with id {int} from the saucedemo table")
    public void the_user_queries_the_username_with_id_from_the_saucedemo_table(int id) {
        String query = LoantechQueries.GET_USERNAME_BY_ID_FROM_SAUCEDEMO;
        DatabaseUtils.createStatement();
        DatabaseUtils.executeQuery(query);
    }

    @Then("the username should be {string}")
    public void the_username_should_be(String expectedName) throws SQLException {
        ResultSet resultSet = DatabaseUtils.getResultSet();

        resultSet.first();

        String actualName = resultSet.getString("username");

        Assert.assertEquals(actualName, expectedName);
    }
}