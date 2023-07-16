package com.vitamojo.framework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver = null;
	
	/** Method to quit a web driver session
	 * 
	 */
	public synchronized static void quitBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	/** Method to close a current window
	 * 
	 */
	public synchronized static void closeBrowser() {
		driver.close();
	}

	/**
	 * Method for initializing the web driver session
	 * 
	 * @param browserName
	 * @return
	 */
	public synchronized static void initBrowser(String browserName) {
		switch (browserName.toLowerCase()) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				if (System.getProperty("runenv").equalsIgnoreCase("ci")){
					options.addArguments("--disable-gpu");
					options.addArguments("--headless");
					options.addArguments("--window-size=1920x1080");
				}
				driver = new ChromeDriver(options);
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "msedge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	/**
	 * Method to get WebElement by their Name
	 * 
	 * @param obj
	 * @return
	 */
	public WebElement getElem(By elem) {
		if (elem != null) {
			return driver.findElement(elem);
		}
		return null;
	}

	/**
	 * Method to get List<WebElement> by their Name
	 * 
	 * @param obj
	 * @return
	 */
	public List<WebElement> getElems(By elems) {
		if (elems != null) {
			return driver.findElements(elems);
		}
		return null;
	}
	
	/** Method to catch error
	 * 
	 * @param th
	 */
	protected void catchError(Throwable th) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		String message = "Exception Occured in method :: " + methodName;
		System.out.println("----------------");
		System.out.println(message);
		System.out.println(th);
		System.out.println("----------------");
		if (getConfig("frameworkss").equalsIgnoreCase("true")) {
			String  screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot).build());
		} else {
			ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, message);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, th);
	}
	
	/** Method to read property file in a file location
	 * 
	 * @param fileloc
	 * @param delimiter
	 * @return
	 * @throws Throwable
	 */
	private static Map<String, String> readPropertyFile(String fileloc, String delimiter) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileloc));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(delimiter)) {
					String key = line.split(delimiter)[0].toString();
					String value = line.split(delimiter)[1].toString();
					map.put(key, value);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * Method to make a get Config data from  config.properties file
	 * <br> it is located at project root directory
	 * @param key
	 * @return
	 */
	public static String getConfig(String key) {
		String fileloc = System.getProperty("user.dir") + System.getProperty("file.separator");
		try {
			Map<String, String> data = readPropertyFile(fileloc + "config.properties", "=");
			if (key != null || key != "") {
				return data.get(key);
			}
		} catch (Throwable th) {

		}
		return "";
	}
	
	/**
	 * Method to make a get test data from data.properties file 
	 * <br> it is located at project root directory
	 * @param key
	 * @return
	 */
	public static String getData(String key) {
		String fileloc = System.getProperty("user.dir") + System.getProperty("file.separator");
		try {
			Map<String, String> data = readPropertyFile(fileloc + "data.properties", "=");
			if (key != null || key != "") {
				return data.get(key);
			}
		} catch (Throwable th) {

		}
		return "";
	}

}
