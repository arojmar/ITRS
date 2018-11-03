@ToTest3
Feature: All the links displayed in the support page are working properly

  Scenario: The links displayed in the categories section are working properly
    Given the support page is loaded and it is correctly displayed
    When the "Link Name" link is clicked and goes to the "URL Link"
    Then the page is opened
    And the page corresponds with the "URL link"

  Examples:
  | Link Name           | URL Link                                             |
  | Welcome             | /hc/en-us/categories/115000681925-Welcome            |
  | Geneos Self-Help    | /hc/en-us/categories/115000687225-Geneos-Self-help   |
  | Geneos Plugin Help  | /hc/en-us/categories/115000687205-Geneos-Plugin-Help |
  | User Guides         | /hc/en-us/categories/115000287873-User-Guides        |
