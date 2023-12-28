@Test
Feature: Test iteration in lists

Scenario Outline: Scenario Outline name: As a tester, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When I search <searchText> in the list
    Then I can find <textToCheck> in the list

    Examples:
    |searchText|textToCheck       |
    |JavaScript|Axel Rauschmayer  |
    |Web       |Glenn Block et al.|
