Feature: Categories table update verification
  
  Scenario: Update description by name in categories table

    Given the user connects to the database
    When the user updates "description" to "premium level" in "categories" table where "name" is "Basic Loan"
    Then the "description" in "categories" table where "name" is "Basic Loan" should be "premium level"
    And the user closes the database connection