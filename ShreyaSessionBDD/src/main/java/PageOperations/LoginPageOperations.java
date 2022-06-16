package PageOperations;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pageLocators.LoginPageLocators;

public class LoginPageOperations extends LoginPageLocators {

	public LoginPageLocators loginPageLocators = new LoginPageLocators();

	@SuppressWarnings("finally")
	public boolean verifyLoginPageTitle() {

		boolean success = false;
		try {
			String expectedTitle = "Guru99 Bank Home Page";
			Assert.assertEquals(getDriver().getTitle(), expectedTitle);
			success = true;
			
			extentTest.log(Status.PASS, "Title matched");

		} catch (AssertionError error) {
			
			extentTest.log(Status.FAIL, error.getMessage());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			return success;
		}
	}

	@SuppressWarnings("finally")
	public boolean LoginInToApplication() {

		boolean success = false;

		try {
			EnterText(getUserNameTextBox(), property.getProperty("username"));
			EnterText(getPasswordTextBox(), property.getProperty("password"));
			ClickOnElement(getLoginButton());
			ExplicitWait(loginPageLocators.getNewCustomer());
			success = true;
			
			extentTest.log(Status.PASS, "Login sucessfull");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			return success;
		}
	}

	@SuppressWarnings("finally")
	public boolean HomePageValidation() {
		boolean success = false;
		try {
			verifyElementIsDisplayed(getNewCustomer());
			
			extentTest.log(Status.PASS, "Home Page is displayed");
			success = true;
			getScreenshot("Login sucessfully");
		}

		catch (Exception e) {
			e.printStackTrace();
			
			extentTest.log(Status.FAIL, "Home Page is Not displayed");
		}

		finally {
			return success;
		}
	}

}
