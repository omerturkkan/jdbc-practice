Feature: Saucedemo table username verification

  @wip
  Scenario: Verify username by id in saucedemo table

    Given the user connects to the database
    When the user queries the username with id 1006 from the saucedemo table
    Then the username should be "visual_user"
    And the user closes the database connection