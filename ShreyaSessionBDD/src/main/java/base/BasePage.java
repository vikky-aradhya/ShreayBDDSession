package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;
import utils.ExcelUtility;

import com.google.common.io.Files;

public class BasePage {

	public static LinkedHashMap<String, String> testdataMap;
	public static String scenarioName;
	public static String description;
	public static int rownum = 1;
	public static WebDriver driver = null;
	public static Properties property = null;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	public static ExcelUtility excelUtility = new ExcelUtility();
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReporter;
	public static ExtentTest extentTest;

	// -----------------------------------------------------------------------------------------------------------------------------

	// This code is to select and launch Browser

	public static WebDriver openBrowser(String browserName) throws Throwable {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} else {
			System.out.println(browserName + " not found, Please specify the correct browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(property.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tdriver.set(driver);
		
		extentTest.log(Status.PASS, "Browser Opened sucessfully");

		return getDriver();

	}

	// -----------------------------------------------------------------------------------------------------------------------------

		// This code is run Driver in Synchronized mode

		public static synchronized WebDriver getDriver() {
			return tdriver.get();
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to read data from properties file

		public static Properties init_properties() {
			property = new Properties();
			try {
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/main/java/config/config.properties");
				property.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return property;
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Navigate to URL

		public static void navigateToUrl() throws Exception {
			// init_properties();
			getDriver().get(property.getProperty("url"));
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Generate Random String

		public static String randomestring() {
			String generatedstring = RandomStringUtils.randomAlphabetic(8);
			return (generatedstring);
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to generate random Number

		public static String randomeNum() {
			String generatedString2 = RandomStringUtils.randomNumeric(4);
			return (generatedString2);
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to generate random Email-ID

		public static String generateRandomEmail(int length) {
			String email = "";
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
			email = (randomestring() + randomInt + "@gmail.com");
			return email;
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to take screen shots

		public static void getScreenshot(String name) {
			
			try {
				File sourcePath = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/screenshots/" + name
						+ System.currentTimeMillis() + ".png");

				Files.copy(sourcePath, destinationPath);
			
				extentTest.log(Status.INFO, "",MediaEntityBuilder.createScreenCaptureFromPath(destinationPath.toString()).build());
			} catch (IOException e) {
				System.out.println("Capture Failed " + e.getMessage());
			}

		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to perform mouse over

		public static void mouseHover(WebElement locator) throws Exception {

			Thread.sleep(2000);
			Actions action = new Actions(getDriver());
			try {
				action.moveToElement(locator).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to perform mouse over click

		public static void mouseHoverClick(WebElement locator) throws Exception {

			Thread.sleep(2000);
			Actions action = new Actions(getDriver());
			try {
				action.moveToElement(locator).click().build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to perform click operation

		public static void ClickOnElement(WebElement element) throws Exception {

			Thread.sleep(2000);
			try {
				element.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Enter text

		public static void EnterText(WebElement element, String value) throws Exception {

			Thread.sleep(2000);
			element.sendKeys(value);
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to perform Explicit wait

		public static void ExplicitWait(WebElement element) {

			try {
				WebDriverWait wait = new WebDriverWait(getDriver(), 30);
				wait.until(ExpectedConditions.visibilityOf(element));
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Verify elements

		public static void verifyElementIsDisplayed(WebElement element) {

			try {
				Assert.assertTrue(element.isDisplayed());
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to select value from drop down

		public static void selectByText(WebElement locator, String value) {

			Select select = new Select(locator);
			try {
				select.selectByVisibleText(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void selectByValue(WebElement locator, String value) {

			Select select = new Select(locator);
			try {
				select.selectByValue(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void selectByIndex(WebElement locator, int value) {

			Select select = new Select(locator);
			try {
				select.selectByIndex(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Accept alert

		public static void acceptAlert() throws Exception {
			Thread.sleep(3000);

			try {
				driver.switchTo().alert().accept();
			}

			catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Dismiss alert

		public static void dismissAlert() throws Exception {
			Thread.sleep(2000);

			try {
				driver.switchTo().alert().dismiss();
			}

			catch (NoAlertPresentException e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to Switch to frame

		public static void switchToFrame(String frameID) throws Exception {
			Thread.sleep(2000);

			try {
				driver.switchTo().frame(frameID);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to perform drag and drop

		public static void dragAndDrop(WebElement source, WebElement destination) throws Exception {
			Thread.sleep(2000);

			Actions action = new Actions(driver);
			try {
				action.dragAndDrop(source, destination).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This code is to perform upload operations

		public static void uploadFile(String location) throws Exception {
			Thread.sleep(2000);

			try {
				Runtime.getRuntime().exec(location);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// -----------------------------------------------------------------------------------------------------------------------------

		// This Code is to close the browser

		public static void closeBrowser() {
			getDriver().quit();
		}

		// -----------------------------------------------------------------------------------------------------------------------------
		
		//This code is to read data from excel sheet

		public static void readexceldata(String ScenarioName, String SheetName) throws Exception {
			testdataMap = excelUtility
					.getTestDataListByScenario(System.getProperty("user.dir") + "\\src\\test\\resources\\supporting_files",
							"TestData_python", SheetName, ScenarioName)
					.get(rownum - 1);
			System.out.println(testdataMap);
			System.out.println(testdataMap.get("Username"));
			System.out.println(testdataMap.get("Scenario"));
			scenarioName = testdataMap.get("Scenario");
			description = testdataMap.get("Description");
		}

		public static void init_extentReport() {
			extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"//target//ExtentReport.html"));
			extentReporter = new ExtentReports();
			extentReporter.attachReporter(extentHtmlReporter);
		}
		
		public static void create_extentTest(String testName) {
			extentTest = extentReporter.createTest(testName);
		}
		
		public static void generateExtentReport() {
			extentReporter.flush();
		}

}
