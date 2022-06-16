package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import base.BasePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		 plugin = {"pretty","html:target/cucumber1"},
		features = { "src/test/java/features" }, 
		glue = {"stepDefinition" }, 
		tags = "@Login_outline", 
		monochrome = true, 
		dryRun = false)

public class TestRunner {

	@BeforeClass
	public static void setUp() {
		BasePage.init_extentReport();
	}

	@AfterClass
	public static void tearDown() {
		BasePage.driver.quit();
		BasePage.generateExtentReport();
	}

}
