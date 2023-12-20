Feature: Test navigation around the Amazon website

Scenario Outline: Scenario Exercise 1: As a tester, I want to validate that an item in the Amazon Website, from an specific page, and an specific order, exists for purchase.
    Given I navigate to the Amazon Website
    And I search for <item> in the products search bar
    And I navigate to the <numberPage> page
    And I select the <numberItem> item
    Then I can assert if the item is available for purchase

    Examples:
    |item|numberPage|numberItem|
    |Alexa|2        |3         |
    |Zelda|5        |5         |