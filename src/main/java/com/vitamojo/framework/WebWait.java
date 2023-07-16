package com.vitamojo.framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Pritam Saha
 *
 */

public class WebWait extends Base {
	
	private int defaultWaitTime = 20;

	public static WebWait getInstance() {
		return new WebWait();
	}

	/** Method to wait for a specified amount of time until an element is Present
	 * 
	 * <br> Use this method when the element is not present in DOM in the initial stage
	 * @param elem
	 * @param timeOutInSeconds
	 */
	public void untilElementPresent(By elem, int timeOutInSeconds){
		try {
			(new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)))
				.until(ExpectedConditions.presenceOfElementLocated(elem));
		} catch(Throwable th){
			catchError(th);
		}
	}

	/** Method to wait until an element is visible
	 * 
	 * <br> Use this method when the element is not present in DOM in the initial stage
	 * @param elem
	 */
	public void untilElementPresent(By elem){
		try {
			(new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime)))
				.until(ExpectedConditions.presenceOfElementLocated(elem));
		}catch(Throwable th){
			catchError(th);
		}
	}

	/** Method to wait for a specified amount of time until an element is visible
	 * 
	 * <br> Use this method only if the element is present in DOM but not visible initially
	 * @param elem
	 * @param timeOutInSeconds
	 */
	public void untilElementVisible(By elem, int timeOutInSeconds){
		try {	
			(new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)))
				.until(ExpectedConditions.visibilityOfElementLocated(elem));
		} catch(Throwable th){
			catchError(th);
		}
	}

	/** Method to wait until an element is visible
	 * 
	 * <br> Use this method only if the element is present in DOM but not visible initially
	 * @param elem
	 */
	public void untilElementVisible(By elem){
		try {
			(new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime)))
				.until(ExpectedConditions.visibilityOfElementLocated(elem));
		} catch(Throwable th){
			catchError(th);
		}
	}

	/** Method to wait until an element disappears
	 * <br> Use this method to check when an element not visible or present in DOM
	 * @param elem
	 * @param timeOutInSeconds
	 */
	public void untilElementDisappears(By elem, int timeOutInSeconds) {
		try {
			(new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)))
				.until(ExpectedConditions.invisibilityOfElementLocated(elem));
		} catch (Throwable th) {
			catchError(th);
		}
	}

	/** Method to wait until an element disappears
	 * 
	 * <br> Use this method to check when an element not visible or present in DOM
	 * @param elem
	 */
	public void untilElementDisappears(By elem) {
		try {
			(new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime)))
				.until(ExpectedConditions.invisibilityOfElementLocated(elem));
		} catch (Throwable th) {
			catchError(th);
		}
	}

	/** Method to wait for DOM load
	 * 
	 */
	public void waitForLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		(new WebDriverWait(driver, Duration.ofSeconds(defaultWaitTime))).until(pageLoadCondition);
	}
}
