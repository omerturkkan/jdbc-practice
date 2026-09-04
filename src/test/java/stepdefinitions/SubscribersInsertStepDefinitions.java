package stepdefinitions;

import io.cucumber.java.en.*;
import manage_queries.LoantechQueries;
import utilities.DatabaseUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubscribersInsertStepDefinitions {

    @When("the user inserts id {string} and email {string} into the subscribers table")
    public void the_user_inserts_id_and_email_into_the_subscribers_table(String id, String email) {
        String query = LoantechQueries.INSERT_SUBSCRIBER;

        PreparedStatement ps = DatabaseUtils.createPreparedStatement(query);
        try {
            ps.setString(1, id);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the user deletes the record with id {string} from the subscribers table")
    public void the_user_deletes_the_record_with_id_from_the_subscribers_table(String id) {
        String query = "DELETE FROM subscribers WHERE id = '" + id + "'";
        DatabaseUtils.executeUpdate(query);
    }
}
