package stepDefinition;

import base.BasePage;
import io.cucumber.java.en.Given;
import pageLocators.LoginPageLocators;

public class LoginOutlineTest extends BasePage {
	
public LoginPageLocators loginPageLocators = new LoginPageLocators();	
	
	@Given("User enters {string} and {string}")
	public void user_enters_and(String username, String password) throws Exception {
		EnterText(loginPageLocators.getUserNameTextBox(), username);
		EnterText(loginPageLocators.getPasswordTextBox(), password);
	}

}
