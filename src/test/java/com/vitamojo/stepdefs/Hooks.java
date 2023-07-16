package com.vitamojo.stepdefs;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.vitamojo.pages.CommonPOM;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonPOM {
	
	@Before()
	public void start(Scenario s) {
		System.out.println("Starting test");
		if (!s.getSourceTagNames().contains("@APITest")) {
			initBrowser(getConfig("browser"));
		}
	}
	
	@AfterStep
	public void takeScreenShotAfterStep(Scenario s) throws IOException {
		if (!s.getSourceTagNames().contains("@APITest")) {
			String  screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			if (getConfig("onlyfailss").equalsIgnoreCase("true") && s.isFailed()) {
		        ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
			} else {
		        ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
			}
		}
	}
	
	@After
	public void end(Scenario s) {
		System.out.println("End of test");
		if (!s.getSourceTagNames().contains("@APITest")) {
			closeBrowser();
		}
	}
}
