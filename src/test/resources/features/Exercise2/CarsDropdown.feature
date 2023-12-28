@Test
Feature: Test TradeMe - Number cars in make dropdown

Scenario Outline: As a tester, I want to validate the number of cars in the make dropdown from the TradeMe website
    Given I navigate to the TradeMe website    
    Then I can assert that the number of cars in the dropdown is <numberDropdown>

    Examples:
    |numberDropdown|
    |82|