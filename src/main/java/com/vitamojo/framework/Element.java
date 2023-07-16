package com.vitamojo.framework;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * @author Pritam Saha
 *
 */

public class Element extends Base {

	public static Element getInstance() {
		return new Element();
	}
	
	
	/** Check if an element is Visible in a DOM
	 * <br> if true - it means it has some size
	 * @param elem
	 * @return
	 */
	public boolean isVisible(By elem) {
		try {
			return getElem(elem).isDisplayed();
		} catch (Throwable th) {
			catchError(th);
		}
		return false;
	}
	
	/** Method to click an element 
	 * 
	 * @param elem
	 */
	public void click(By elem){
		try {
			WebElement ele = getElem(elem);
			ele.click();
		} catch (Throwable th) {
			catchError(th);
		}
	}

	/** Method to click an element by JS
	 * 
	 * @param elem
	 */
	public void clickUsingJS(By elem){
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", getElem(elem));
			Thread.sleep(2000);
		} catch (Throwable th) {
			catchError(th);
		}
	}
	
	/** Method to get visible text from element
	 * 
	 * @param elem
	 * @return
	 */
	public String getText(By elem){
		try {
			WebElement ele = getElem(elem);
			return ele.getText();
		} catch (Throwable th) {
			catchError(th);
		}
		return "";
	}
	
	/** Method to get an attribute value from element 
	 * 
	 * @param elem
	 * @param attribute
	 * @return
	 */
	public String getAttribute(By elem, String attribute){
		try {
			WebElement ele = getElem(elem);
			return ele.getAttribute(attribute);
		} catch (Throwable th) {
			catchError(th);
		}
		return "";
	}

	/** Method to input some values in an Input box
	 * 
	 * @param elem
	 * @param value
	 */
	public void sendkeys(By elem, String value){
		try {
			WebElement ele = getElem(elem);
			clearInput(elem);
			if (!Objects.isNull(value)) {
				ele.sendKeys(value);
			}
			Thread.sleep(1000);
		} catch (Throwable th) {
			catchError(th);
		}
	}

	/** Method to send some key strokes in an Input box
	 * 
	 * @param elem
	 * @param key
	 */
	public void sendkeys(By elem, Keys key){
		try {
			WebElement ele = getElem(elem);
			ele.clear();
			ele.sendKeys(key);
		} catch (Throwable th) {
			catchError(th);
		}
	}

	/** Method to get value from an InputBox which has a value
	 * 
	 * <br> By default using 'value' attribute to get the value.
	 * @param elem
	 * @param value
	 * @return
	 */
	public String getValue(By elem) {
		String value = "";
		try {
			WebElement ele = getElem(elem);
			value = ele.getAttribute("value");
		} catch (Throwable th) {
			catchError(th);
		}
		return value;
	}
	
	/** Method to get value from an InputBox which has a value
	 * 
	 * @param elem
	 * @param attribute
	 * @return
	 */
	public String getValue(By elem, String attribute) {
		try {
			WebElement ele = getElem(elem);
			return ele.getAttribute(attribute);
		} catch (Throwable th) {
			catchError(th);
		}
		return "";
	}
	
	/** Method to clear values from input box by JS command
	 * 
	 * @param elem
	 * @return
	 */
	public void clearByJS(By elem) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='';", getElem(elem));
		} catch (Throwable th) {
			catchError(th);
		}
	}
	
	private void clearInput(By elem) {
		try {
			int length = getValue(elem).length();
			while(length > 0) {
				sendkeys(elem, Keys.BACK_SPACE);
				-- length;
			}
		} catch (Throwable th) {
			catchError(th);
		}
	}
}
