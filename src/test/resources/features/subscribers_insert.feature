Feature: Subscribers table insert verification
  @wip
  Scenario: Insert a new subscriber and verify

    Given the user connects to the database
    And the user deletes the record with id "150" from the subscribers table
    When the user inserts id "150" and email "testuser@jdbc.com" into the subscribers table
    Then the "email" in "subscribers" table where "id" is "150" should be "testuser@jdbc.com"
    And the user deletes the record with id "150" from the subscribers table

    And the user closes the database connection