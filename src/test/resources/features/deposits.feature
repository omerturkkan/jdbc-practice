Feature: Deposits table query verification

  Scenario: Verify record count within a specific amount range

    Given the user connects to the database
    When the user queries "amount" values from the "deposits" table
    Then there should be 10 records with amount between 100 and 500
    And the user closes the database connection