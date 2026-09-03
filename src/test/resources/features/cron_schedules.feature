Feature: Cron schedules table name verification

  Scenario: Verify first two name values in cron_schedules table

    Given the user connects to the database
    When the user queries "name" values from the "cron_schedules" table
    Then record 1 should have name "5 Minutes"
    And record 2 should have name "10 Minutes"
    And the user closes the database connection