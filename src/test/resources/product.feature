Feature: Product Selection Functionality

  Scenario: User press Home Tab and clicks add first product in the list
    Given User is on home page
    When User press home tab
    And User selects first product
    Then User clicks on Add to Cart button
    And Alert message popups Product Added
    And Browser closes