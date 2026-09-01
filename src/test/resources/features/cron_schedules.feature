Feature: Cron schedules table name verification

  Scenario: Verify first two name values in cron_schedules table

    Given the user connects to the database
    When the user queries names from the cron_schedules table
    Then the first two names should be "5 Minutes" and "10 Minutes"
    And the user closes the database connection