Feature: Login Action

Background: User Navigates to application
    When User opens browser
    
 @Login_outline    
Scenario Outline: Successful Login with Valid Credentials
	Given Login page is loaded
	And User enters "<username>" and "<password>"
	
Examples:
    | username   | password |
    | mngr47659 | 1@ |
    | testuser_2 | Test@153 |