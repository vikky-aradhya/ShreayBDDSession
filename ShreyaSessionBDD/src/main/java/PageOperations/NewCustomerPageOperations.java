package PageOperations;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import pageLocators.NewCustomerPageLocators;

public class NewCustomerPageOperations extends NewCustomerPageLocators {

public NewCustomerPageLocators newCustomerPageLocators = new NewCustomerPageLocators();	
	
	@SuppressWarnings("finally")
	public boolean clickOnRegisterPage() {

		boolean success = false;
		try {
			ClickOnElement(geNewCustomerLink());
			String expectedTitle = "Guru99 Bank Manager HomePage";
			Assert.assertEquals(getDriver().getTitle(), expectedTitle);
			success = true;
			
			extentTest.log(Status.PASS, "Title matched");

		} catch (AssertionError error) {
			
			extentTest.log(Status.FAIL, error.getMessage());

		} catch (Exception e) {
			e.printStackTrace();
			
			extentTest.log(Status.FAIL, "Title don't matched");
			
		} finally {
			return success;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean CreateNewCustomer(String DOB, String Address, String City, String State, String Pin, String password) {

		boolean success = false;

		try {			
			EnterText(geCustometNameTextBox(), randomestring());
			ClickOnElement(geGenderradioButton());
			EnterText(geDOBTextBox(), DOB);
			EnterText(geAddressTextBox(), Address);
			EnterText(geCityTextBox(), City);
			EnterText(geStateTextBox(), State);
			EnterText(gePINTextBox(), Pin);
			
			EnterText(gePhoneNumberTextBox(), randomeNum());
			EnterText(geEmailIDTextBox(), generateRandomEmail(6));
			EnterText(gepasswordTextBox(), password);			

			
			extentTest.log(Status.PASS, "user Entered information sucessfully");
			success = true;
		}

		catch (Exception e) {
			e.printStackTrace();
				
			extentTest.log(Status.FAIL, "Failed to enter required information");
		}

		finally {
			return success;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean CreateNewCustomerSubmit() {

		boolean success = false;

		try {			
			ClickOnElement(geSubmitButton());			

			
			extentTest.log(Status.PASS, "user clicked submit button sucessfull");
			success = true;
		}

		catch (Exception e) {
			e.printStackTrace();
				
			extentTest.log(Status.FAIL, "Failed to click submit button");
		}

		finally {
			return success;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean verifyRegisterMessage() {

		boolean success = false;

		try {						
			verifyElementIsDisplayed(geRegisteredMessage());

			
			extentTest.log(Status.PASS, "user Registered sucessfully");
			success = true;
			getScreenshot("Register");
		}

		catch (Exception e) {
			e.printStackTrace();
				
			extentTest.log(Status.FAIL, "Failed to Registered");
		}

		finally {
			return success;
		}
	}

}
