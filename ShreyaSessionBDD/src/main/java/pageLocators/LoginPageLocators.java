package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPageLocators extends BasePage {

	@FindBy(name = "uid")
	private WebElement UserNameTextBox;

	@FindBy(name = "password")
	private WebElement PasswordTextBox;

	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement LoginButton;

	@FindBy(xpath = "//a[text()='New Customer']")
	private WebElement NewCustomer;

	public LoginPageLocators() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement getUserNameTextBox() {
		return UserNameTextBox;
	}

	public WebElement getPasswordTextBox() {
		return PasswordTextBox;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getNewCustomer() {
		return NewCustomer;
	}

}
