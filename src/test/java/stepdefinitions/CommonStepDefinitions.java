package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import utilities.DatabaseUtils;

public class CommonStepDefinitions {

    @Given("the user connects to the database")
    public void the_user_connects_to_the_database() {
        DatabaseUtils.getConnection();
    }

    @When("the user queries {string} values from the {string} table")
    public void the_user_queries_values_from_the_table(String column, String table) {
        String query = LoantechQueries.query(column, table);
        DatabaseUtils.createStatement();
        DatabaseUtils.executeQuery(query);
    }

    @Then("the user closes the database connection")
    public void the_user_closes_the_database_connection() {
        DatabaseUtils.closeConnection();
    }
}