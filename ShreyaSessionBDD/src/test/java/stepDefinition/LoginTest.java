package stepDefinition;

import org.testng.Assert;

import PageOperations.LoginPageOperations;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginTest extends BasePage {
	
	public LoginPageOperations loginPageOperations = new LoginPageOperations();

	@Given("Login page is loaded")
	public void login_page_is_loaded() throws Throwable {
		
		create_extentTest("Use Case One");
		boolean isVerifyLoginPageTitle = loginPageOperations.verifyLoginPageTitle();		
		Assert.assertTrue(isVerifyLoginPageTitle);
	}

	@And("user Enters the user name and password and clicks on login button")
	public void user_Enters_the_user_name_and_password() throws Throwable {
		boolean isLoginInToApplication = loginPageOperations.LoginInToApplication();
		Assert.assertTrue(isLoginInToApplication);
	}

	@Then("user validates HomePage")
	public void user_validates_HomePage() throws Throwable {
		boolean isHomePagevalidation = loginPageOperations.HomePageValidation();
		Assert.assertTrue(isHomePagevalidation);
	}

}
