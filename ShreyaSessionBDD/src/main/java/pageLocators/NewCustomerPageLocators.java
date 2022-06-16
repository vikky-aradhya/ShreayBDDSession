package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class NewCustomerPageLocators extends BasePage {

	@FindBy(xpath = "//a[text()='New Customer']")
	private WebElement NewCustomerLink;

	@FindBy(name = "name")
	private WebElement CustometNameTextBox;

	@FindBy(name = "rad1")
	private WebElement GenderradioButton;

	@FindBy(name = "dob")
	private WebElement DOBTextBox;

	@FindBy(name = "addr")
	private WebElement AddressTextBox;

	@FindBy(name = "city")
	private WebElement CityTextBox;

	@FindBy(name = "state")
	private WebElement StateTextBox;

	@FindBy(name = "pinno")
	private WebElement PINTextBox;

	@FindBy(name = "telephoneno")
	private WebElement PhoneNumberTextBox;

	@FindBy(name = "emailid")
	private WebElement EmailIDTextBox;

	@FindBy(name = "password")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement SubmitButton;

	@FindBy(xpath = "//p[text()='Customer Registered Successfully!!!']")
	private WebElement RegisteredMessage;

	public NewCustomerPageLocators() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement geNewCustomerLink() {
		return NewCustomerLink;
	}

	public WebElement geCustometNameTextBox() {
		return CustometNameTextBox;
	}

	public WebElement geGenderradioButton() {
		return GenderradioButton;
	}

	public WebElement geDOBTextBox() {
		return DOBTextBox;
	}

	public WebElement geAddressTextBox() {
		return AddressTextBox;
	}

	public WebElement geCityTextBox() {
		return CityTextBox;
	}

	public WebElement geStateTextBox() {
		return StateTextBox;
	}

	public WebElement gePINTextBox() {
		return PINTextBox;
	}

	public WebElement gePhoneNumberTextBox() {
		return PhoneNumberTextBox;
	}

	public WebElement geEmailIDTextBox() {
		return EmailIDTextBox;
	}

	public WebElement gepasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement geSubmitButton() {
		return SubmitButton;
	}

	public WebElement geRegisteredMessage() {
		return RegisteredMessage;
	}

}
