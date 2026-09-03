Feature: Subscribers table gmail count verification

  Scenario: Verify gmail subscriber count is more than 5

    Given the user connects to the database
    When the user queries "email" values from the "subscribers" table
    Then the gmail count should be more than 5
    And the user closes the database connection