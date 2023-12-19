@Test
Feature: Test iteration in lists

Scenario: As a tester, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When I search on the list
    Then I can find the text in the list