package stepDefinition;

import PageOperations.NewCustomerPageOperations;
import base.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class RegisterTest extends BasePage {
	
public NewCustomerPageOperations newCustomerPageOperations = new NewCustomerPageOperations();
	
	@Then("user clicks on New Customer Link")
	public void user_clicks_on_new_customer_link() throws Throwable {
		newCustomerPageOperations.clickOnRegisterPage();
	}
	
	@And("user enters Required Information")
	public void user_enters_Required_Information() throws Throwable {
		newCustomerPageOperations.CreateNewCustomer(testdataMap.get("DOB"), testdataMap.get("Address"), 
				testdataMap.get("CityName"), testdataMap.get("StateName"), testdataMap.get("PinNumber"), testdataMap.get("Password"));
	}
	
	@Then("user clicks on submit")
	public void user_clicks_on_submit() throws Throwable {
		newCustomerPageOperations.CreateNewCustomerSubmit();
	}
	
	@And("verify the Register Page title")
	public void verify_the_register_page_title() throws Throwable {
		newCustomerPageOperations.verifyRegisterMessage();
	}
	

}
