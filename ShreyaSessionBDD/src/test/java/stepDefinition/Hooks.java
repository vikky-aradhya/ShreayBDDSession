package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks extends BasePage {
	
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				File sourcePath = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(System.getProperty("user.dir") + "/target/screenshots/" + screenshotName + System.currentTimeMillis()+ ".png");
				
				Files.copy(sourcePath, destinationPath);  
								
				extentTest.log(Status.FAIL, "Test Case is Failed",MediaEntityBuilder.createScreenCaptureFromPath(destinationPath.toString()).build());	        
			} catch (Exception e) {
			} 
		}
	}

}
