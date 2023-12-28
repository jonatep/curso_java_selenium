@Test
Feature: Test TradeMe - Number cars in make dropdown

Scenario Outline: Scenario Exercise 1: As a tester, I want to validate the number of cars from specific brands
    Given I navigate to the TradeMe website    
    When I select the car <car> in the make dropdown
    Then I can assert that the number of cars from that brand is <amount>

    Examples:
    |car|amount|
    |Ferrari|44|       
    |BMW|2672|       
    |Mazda|5954|       
    |Honda|3279|