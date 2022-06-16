package stepDefinition;

import com.cucumber.listener.Reporter;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BrowserFactory extends BasePage {
	
	@When("User opens browser")
	public void user_opens_browser() throws Throwable {
		try {
			init_properties();
			openBrowser(property.getProperty("browser"));
			
		} catch (Exception e) {
			e.getMessage();
		}
		try {
			navigateToUrl();			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	@Given("test data is read from excel {string} under {string}")
	public void test_data_is_read_from_excel_under(String scenarioName, String sheetName) throws Exception {
		System.out.println(scenarioName);
		System.out.println(sheetName);
		readexceldata(scenarioName, sheetName);
		Thread.sleep(3000);
	}

}
