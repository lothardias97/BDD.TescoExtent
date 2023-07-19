Feature: Search an item on tesco page

  Background:
    Given  User is on Tesco page
    When User accepts cookies

  @smoke
  Scenario: Verify pizza items on tesco page
    And User searches for "pizza" in the search box
    When User clicks on search button
    Then User verifies pizza items
