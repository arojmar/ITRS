@ToTest
Feature: A user want to search information in the search button in the main page

  Scenario: A user access to the ITRS Group main page and select the search button
    Given a user accesses to the main ITRS page
    When user selects the search button
    Then the searching bar is displayed
    
  Scenario: A user clicks on the search button and type a word for searching the information
    Given a user accesses to the main ITRS page
    When user selects the search button
    And the searching bar is displayed
    Then user types the word "hello" in the searching bar
    And the result page is displayed