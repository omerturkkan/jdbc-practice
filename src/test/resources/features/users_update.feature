Feature: Users table update verification

  Scenario: Update username by id and verify

    Given the user connects to the database
    When the user updates "username" to "testuser13" in "users" table where "id" is "13"
    Then the "username" in "users" table where "id" is "13" should be "testuser13"
    And the user closes the database connection