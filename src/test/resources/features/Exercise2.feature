Feature: Test navigation around the TradeMe website

Background: Navigate to the TradeMe website
    Given I navigate to the TradeMe website

Scenario: As a tester, I want to validate that the number of cars in the make dropdown from the TradeMe website is 82
    Then I can assert that the number of cars in the dropdown is 82

@Test
Scenario Outline: Scenario Exercise 1: As a tester, I want to validate the number of cars from specific brands
    When I select the car <car> in the make dropdown
    Then I can assert that the number of cars from that brand is <amount>

    Examples:
    |car|amount|
    |Ferrari|44|       
    |BMW|2672|       
    |Mazda|5954|       
    |Honda|3279|

Scenario: As a tester, I want to validate that the number of cars from the TradeMe API is X
    Then I can assert that the number of cars in the TradeMe API is X




     