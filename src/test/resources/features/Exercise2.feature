@Test
Feature: Test navigation around the TradeMe website

Scenario Outline: As a tester, I want to validate the number of cars in the make dropdown from the TradeMe website
    Given I navigate to the TradeMe website    
    Then I can assert that the number of cars in the dropdown is <numberDropdown>

    Examples:
    |numberDropdown|
    |82|

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

Scenario Outline: As a tester, I want to validate the number of cars from the TradeMe API
    Given I send a GET request to the API adress
    Then I can assert that the number of cars in the TradeMe API is <numberAPI>

    Examples:
    |numberAPI|
    |82|