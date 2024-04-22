@ui
Feature: Products Sauce Demo App Tests
  Users checks the products in the Swag Labs

  Scenario Outline: Validate the list of products
    Given User navigates to the SauceDemo login page
    And the user logs in with "<username>" and "<password>"
    Then the user should be seeing the list of products available

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | performance_glitch_user  | secret_sauce |
      | error_user  | secret_sauce |
      | visual_user  | secret_sauce |