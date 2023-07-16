package com.vitamojo.pages;

import org.openqa.selenium.By;

import com.vitamojo.framework.Element;
import com.vitamojo.framework.WebWait;

public class LandingPOM extends CommonPOM {

	protected static By btnLogin = By.xpath("//*[@data-test=\"header-profile-link\"]");
	protected static By inputEmail = By.id("email");
	
	public void loadPortal() throws Throwable{
		driver.get(getData("baseurl"));
		WebWait.getInstance().waitForLoad();
		WebWait.getInstance().untilElementVisible(btnLogin, 30);
	}
	
	public void navigateToAuth() throws Throwable{
		Element.getInstance().click(btnLogin);
	}
	
	public void verifyAuthPage() throws Throwable{
		WebWait.getInstance().untilElementPresent(formContainer, 30);
		assertElemVisible(formContainer);
	}
}
