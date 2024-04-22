@ui
Feature: Cart Sauce Demo App Tests
  Users operates the Cart in the Swag Labs

  Scenario Outline: Validate the login functionality with the valid usernames
    Given User navigates to the SauceDemo login page
    And the user logs in with "<username>" and "<password>"
    And user adds a backpack to the cart
    And checks if the cart badge is updated
    And user goes to the cart
    When user clicks on checkout
    And user is on checkout page
    And fills in his data "<name>" and "<lastName>" and "<postalCode>" and press continue
    Then the user should see the purchase completed message
    Examples:
      | username      | password     | postalCode | name | lastName |
      | standard_user | secret_sauce | 123456|   test        |  test        |
      | problem_user  | secret_sauce | 123456|   test        |  test        |
      | performance_glitch_user  | secret_sauce | 123456 |test |test        |
      | error_user  | secret_sauce | 123456  |  test         |  test        |
      | visual_user  | secret_sauce | 123456 |  test         |  test        |