Feature: Login into an application

Background: User Navigates to application
    When User opens browser
    
  @Login_user
  Scenario: Login
    Given Login page is loaded
    And user Enters the user name and password and clicks on login button
    Then user validates HomePage