@SupportPageLinks @ToTest
Feature: All the links displayed in the support page are working properly

  @CategoriesLinks
  Scenario Outline: The links displayed in the categories blocks section are working properly
    Given the support page is loaded and it is correctly displayed
    When the "<Link Name>" link is clicked
    Then the page opened corresponds with the "<URL Link>"

    Examples:
      | Link Name          | URL Link                                             |
      | Welcome            | /hc/en-us/categories/115000681925-Welcome            |
      | Geneos Self-Help   | /hc/en-us/categories/115000687225-Geneos-Self-help   |
      | Geneos Plugin Help | /hc/en-us/categories/115000687205-Geneos-Plugin-Help |
      | User Guides        | /hc/en-us/categories/115000287873-User-Guides        |

  @AllLinks
  Scenario Outline: The links displayed in the Promoted articles section are working properly
    Given the support page is loaded and it is correctly displayed
    When each of the "<Section>" links are clicked
    Then the "<Section>" pages is displayed correctly

    Examples:
      | Section          |
      | categorie blocks |
      | articles         |
      | activity         |