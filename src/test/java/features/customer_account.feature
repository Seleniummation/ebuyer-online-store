Feature: Customer Account

  Background:
    Given Customers are on "ebuyer" home page

  @Regression
  Scenario Outline: Log in with valid credentials
    And Customer clicks "sign in" link
    And Customer enters "<email address>" and "<password>"
    When Customer clicks sign in
    Then Username of customer is displayed
    Examples:
      | email address      | password |
      | taniwono@gmail.com | Ladies03 |

    Scenario: Sign in functionality
    When Customer clicks "sign in" link
    Then Sign in or register text is displayed
