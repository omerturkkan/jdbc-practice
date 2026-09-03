Feature: Subscribers table email verification

  Scenario: Verify email by id in subscribers table

    Given the user connects to the database
    When the user queries the email with id 20 from the subscribers table
    Then the email should be "raisa.price@gmail.com"
    And the user closes the database connection