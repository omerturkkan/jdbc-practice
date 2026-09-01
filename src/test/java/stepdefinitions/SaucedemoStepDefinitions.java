package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

import static stepdefinitions.CommonStepDefinitions.*;

public class SaucedemoStepDefinitions {

    @When("the user queries the username with id {int} from the saucedemo table")
    public void the_user_queries_the_username_with_id_from_the_saucedemo_table(int id) throws SQLException {
        String query = LoantechQueries.GET_USERNAME_BY_ID_FROM_SAUCEDEMO;

        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        resultSet = statement.executeQuery(query);
    }

    @Then("the username should be {string}")
    public void the_username_should_be(String expectedName) throws SQLException {
        resultSet.first();

        String actualName = resultSet.getString("username");

        Assert.assertEquals(actualName, expectedName);
    }
}