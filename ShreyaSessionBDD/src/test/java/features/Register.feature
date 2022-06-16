Feature: Register into an application

  Background: User Navigates to application
    When User opens browser

  @Register_user
  Scenario: Register
    Given Login page is loaded
    And user Enters the user name and password and clicks on login button
    Then user validates HomePage
    Given test data is read from excel "Register" under "Sheet2"
    Then user clicks on New Customer Link
    And user enters Required Information
    Then user clicks on submit
    And verify the Register Page title
