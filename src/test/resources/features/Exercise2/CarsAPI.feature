@Test
Feature: Test TradeMe - Number cars in make dropdown

Scenario Outline: As a tester, I want to validate the number of cars from the TradeMe API
    Given I send a GET request to the API adress
    Then I can assert that the number of cars in the TradeMe API is <numberAPI>

    Examples:
    |numberAPI|
    |81|