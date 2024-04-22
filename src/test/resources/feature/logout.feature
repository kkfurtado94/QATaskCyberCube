@ui
Feature: Logout Sauce Demo App Tests
  Logout validation Swag Labs


  Scenario Outline: Successful logout from Swag Labs
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    And the user should be seeing the home page
    And user attempts to log out
    Then the user is back to the login page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | performance_glitch_user  | secret_sauce |
      | error_user  | secret_sauce |
      | visual_user  | secret_sauce |

  Scenario Outline: Logout from Swag Labs and navigates back to the previous page
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    And the user should be seeing the home page
    And user attempts to log out
    And navigates back to the previous page
    Then the user should be seeing the Invalid Access to Inventory message
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | performance_glitch_user  | secret_sauce |
      | error_user  | secret_sauce |
      | visual_user  | secret_sauce |

  Scenario Outline: (SCENARIO FAILING DUE TO BUG ON SAUCELABS) Check session termination after logout
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    And the user should be seeing the home page
    And user will add a backpack to the cart
    And user attempts to log out
    And the user logs in with "<username2>" and "<password>"
    And the user should be seeing the home page
    Then the cart should be empty
    Examples:
      | username      | password     | username2 |
      | standard_user | secret_sauce | performance_glitch_user |