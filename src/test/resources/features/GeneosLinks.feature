@SupportPageLinks
Feature: All the links displayed in the Geneos Page are working properly

  #This approach is for getting tested all the links for each of the sections (in just one Outline scenario)
  @AllLinks
  Scenario: The links displayed in the Geneos page are working properly
    Given the Geneos page is loaded and it is correctly displayed
    When each of the links in Geneos Page are clicked
    Then the opend pages corresponds with the URL in the links clicked
