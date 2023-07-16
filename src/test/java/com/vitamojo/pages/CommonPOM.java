package com.vitamojo.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import com.vitamojo.framework.Base;
import com.vitamojo.framework.Element;
import com.vitamojo.framework.WebWait;

public class CommonPOM extends Base {
	
	//	Page Objects
	protected static By tabLogin = By.xpath("//li[@data-test=\"auth-tab-login\"]");
	protected static By tabRegistration = By.xpath("//li[@data-test=\"auth-tab-register\"]");
	protected static By formContainer = By.xpath("//form[@id=\"auth\"]");
	protected static By pageHeader = By.xpath("//ul/preceding::h2[1]");
	protected static By profileLink = By.xpath("//a[@data-test=\"header-profile-link\"]");
	protected static By userName = By.xpath("//a[@data-test=\"header-profile-link\"]//span[2]");

	// Common Methods
	
	public void assertElemVisible(By elem) {
		WebWait.getInstance().untilElementVisible(elem);
		assertThat(getElems(elem).size()).isGreaterThan(0);
	}
	
	public void switchToLoginTab() {
		assertElemVisible(tabLogin);
		Element.getInstance().click(tabLogin);
	}
	
	public void switchToRegistrationTab() {
		assertElemVisible(tabRegistration);
		Element.getInstance().click(tabRegistration);
	}
	
	public void verifyPageheader(String header) {
		assertElemVisible(pageHeader);
		assertThat(Element.getInstance().getText(pageHeader)).isEqualTo(header);
	}
	
	public void verifySuccessfulLogin(String name) {
		WebWait.getInstance().untilElementPresent(profileLink);
		assertElemVisible(profileLink);
		assertElemVisible(userName);
		assertThat(Element.getInstance().getText(userName)).isEqualTo(name);
	}
}
