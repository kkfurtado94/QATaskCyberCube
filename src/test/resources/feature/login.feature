@ui
Feature: Login Sauce Demo App Tests
  Users logs in the Swag Labs

  Scenario Outline: Validate the login functionality with the valid usernames
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the home page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |
      | performance_glitch_user  | secret_sauce |
      | error_user  | secret_sauce |
      | visual_user  | secret_sauce |

  Scenario Outline: Validate the login functionality with the locked out user
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the locked out message

    Examples:
      | username      | password     |
      | locked_out_user | secret_sauce |

  Scenario Outline: Validate the login functionality with invalid username and valid password
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the Password and Username not matching message
    Examples:
      | username      | password     |
      | invalid_user | secret_sauce |

  Scenario Outline: Validate the login functionality with valid username and invalid password
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the Password and Username not matching message
    Examples:
      | username      | password     |
      | performance_glitch_user | invalid_password  |
      | error_user    | invalid_password    |
      | visual_user   | invalid_password    |
      | standard_user | invalid_password    |
      | problem_user  | invalid_password    |

  Scenario Outline: Validate the login functionality with invalid username and invalid password
    Given User navigates to the SauceDemo login page
    When the user logs in with "<username>" and "<password>"
    Then the user should be seeing the Password and Username not matching message
    Examples:
      | username      | password     |
      | invalid_user | invalid_password       |
