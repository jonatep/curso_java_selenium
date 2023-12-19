Feature: Test different actions on a grid page.

Scenario: As a tester, I want to retrieve the value of an static table.
    Given I navigate to the static table
    Then I can return the value I wanted

Scenario: As a tester, I want to check if a table is displayed.
    Given I navigate to the static table    
    Then I can validate the table is displayed