package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import org.testng.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;

import static stepdefinitions.CommonStepDefinitions.*;

public class SubscribersStepDefinitions {

    @When("the user queries the email with id {int} from the subscribers table")
    public void the_user_queries_the_email_with_id_from_the_subscribers_table(int id) throws SQLException {
        String query = LoantechQueries.GET_EMAIL_BY_ID_FROM_SUBSCRIBERS;

        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        resultSet = statement.executeQuery(query);
    }

    @Then("the email should be {string}")
    public void the_email_should_be(String expectedEmail) throws SQLException {
        resultSet.first();

        String actualEmail = resultSet.getString("email");
        Assert.assertEquals(actualEmail, expectedEmail);
    }
}