@ui
Feature: Login Error Messages Sauce Demo App Tests
  Error Message validation Swag Labs

  Scenario Outline: Validate the error message with empty username
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the Username is required message
    Examples:
      | username      | password     |
      |  | invalid_password       |
      |  | secret_sauce        |

  Scenario Outline: Validate the error message with empty password
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the Password is required message
    Examples:
      | username      | password     |
      | standard_user |         |
      | visual_user   |         |