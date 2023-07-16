package com.vitamojo.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.vitamojo.framework.Element;
import com.vitamojo.framework.WebWait;


public class AuthPOM extends CommonPOM {
	
	protected static By emailLabel = By.xpath("//*[@label=\"Email address\"]/../label");
	protected static By inputEmail = By.name("email");
	protected static By emailErrorMsg = By.xpath("//*[@data-test=\"email-validation-msg\"]");
	
	protected static By passwordLabel = By.xpath("//*[@label=\"Password\"]/../label");
	protected static By inputPassword = By.name("password");
	protected static By passwordErrorMsg = By.xpath("//*[@data-test=\"password-validation-msg\"]");
	
	protected static By nameLabel = By.xpath("//*[@label=\"Name\"]/../label");
	protected static By inputName = By.name("firstName");
	protected static By nameErrorMsg = By.xpath("//*[@data-test=\"firstName-validation-msg\"]");
	
	protected static By loyaltySection = By.xpath("//*[@data-test=\"loyalty-advert\"]");
	protected static By alert = By.xpath("//*[@data-test=\"alert\"]");
	
	protected static By forgotPasswordHeader = By.xpath("//*[@id=\"headerPortal\"]//h1");
	protected static By forgotPasswordText = By.xpath("//form[@id=\"forgotten\"]/span");
	protected static By btnResetLink = By.xpath("//button[@data-test=\"forgotten-button\"]");
	protected static By btnHeaderBack = By.xpath("//button[@data-test=\"header-back-btn\"]");
	
	protected static By linkPrivacy = By.xpath("//a[@data-test=\"privacy-link\"]");
	protected static By headerPrivacy = By.xpath("//*[@data-test=\"privacy-header-txt\"]");
	
	protected static By linkTerms = By.xpath("//a[@data-test=\"terms-link\"]");
	protected static By headerTerms = By.xpath("//*[@data-test=\"terms-header-txt\"]");
	
	protected static By btnForgotPassword = By.xpath("//button[contains(text(),\"Forgot password\")]");
	protected static By btnLoginRegistration = By.xpath("//*[@data-test=\"auth-button\"]");
	
	
	public void updateName(String name) {
		assertElemVisible(inputName);
		assertThat(Element.getInstance()
					.getText(nameLabel))
						.isEqualTo(getData("namelabel"));
		Element.getInstance().sendkeys(inputName, name);
	}
	
	public void validateNameErrorMsg(String msg) {
		Element.getInstance().sendkeys(inputName, Keys.ENTER);
		if(Element.getInstance().isVisible(nameErrorMsg)) {
			assertThat(Element.getInstance().getText(nameErrorMsg))
				.isNotNull().isNotBlank().isEqualTo(msg);
		}
	}
	
	public void updateEmail(String email) {
		assertElemVisible(inputEmail);
		assertThat(Element.getInstance()
					.getText(emailLabel))
						.isEqualTo(getData("emaillabel"));
		Element.getInstance().sendkeys(inputEmail, email);
	}
	
	public void validateEmailErrorMsg(String msg) {
		Element.getInstance().sendkeys(inputEmail, Keys.ENTER);
		if(Element.getInstance().isVisible(emailErrorMsg)) {
			assertThat(Element.getInstance().getText(emailErrorMsg))
				.isNotNull().isNotBlank().isEqualTo(msg);
		}
	}
	
	public void updatePassword(String password) {
		assertElemVisible(inputPassword); 
		assertThat(Element.getInstance()
					.getText(passwordLabel))
						.isEqualTo(getData("passwordlabel"));
		Element.getInstance().sendkeys(inputPassword, password);
	}
	
	public void validatePasswordErrorMsg(String msg) {
		Element.getInstance().sendkeys(inputPassword, Keys.ENTER);
		if(Element.getInstance().isVisible(passwordErrorMsg)) {
			assertThat(Element.getInstance().getText(passwordErrorMsg))
				.isNotNull().isNotBlank().isEqualTo(msg);
		}
	}
	
	public void clickAuthBtn() {
		assertElemVisible(btnLoginRegistration);
		Element.getInstance().clickUsingJS(btnLoginRegistration);
	}

	public void verifyAlert(String msg) {
		assertElemVisible(alert);
		assertThat(Element.getInstance().getText(alert))
			.isNotNull().isNotEmpty().isEqualTo(msg);
	}
	
	public void verifyLoyaltyCard( ) {
		assertElemVisible(loyaltySection);
	}
	
	public void navigatetoForgotPasswordPage() {
		assertElemVisible(btnForgotPassword);
		Element.getInstance().clickUsingJS(btnForgotPassword);
		WebWait.getInstance().untilElementPresent(forgotPasswordHeader, 30);
	}
	
	public void verifyForgotPasswordHeader(String txt) {
		assertElemVisible(forgotPasswordHeader);
		assertThat(Element.getInstance().getText(forgotPasswordHeader))
		.isNotNull().isNotEmpty().isEqualTo(txt);
	}
	
	public void verifyForgotPasswordText(String txt) {
		assertElemVisible(forgotPasswordText);
		assertThat(Element.getInstance().getText(forgotPasswordText))
		.isNotNull().isNotEmpty().isEqualTo(txt);
	}
	
	public void verifyResetBtn(String btnTxt) {
		assertElemVisible(btnResetLink);
		assertThat(Element.getInstance().getText(btnResetLink))
		.isNotNull().isNotEmpty().isEqualTo(btnTxt);
	}
	
	public void returnToLogin() {
		assertElemVisible(btnHeaderBack);
		Element.getInstance().clickUsingJS(btnHeaderBack);
		WebWait.getInstance().untilElementPresent(formContainer, 30);
	}
	
	public void navigateToPrivacy() {
		assertElemVisible(linkPrivacy);
		Element.getInstance().clickUsingJS(linkPrivacy);
		WebWait.getInstance().untilElementPresent(headerPrivacy, 30);
	}
	
	public void verifyPrivacyHeader(String txt) {
		assertElemVisible(headerPrivacy);
		assertThat(Element.getInstance().getText(headerPrivacy))
		.isNotNull().isNotEmpty().isEqualTo(txt);
	}
	
	public void navigateToTerms() {
		assertElemVisible(linkTerms);
		Element.getInstance().clickUsingJS(linkTerms);
		WebWait.getInstance().untilElementPresent(headerTerms, 30);
	}
	
	public void verifyTermsHeader(String txt) {
		assertElemVisible(headerTerms);
		assertThat(Element.getInstance().getText(headerTerms))
		.isNotNull().isNotEmpty().isEqualTo(txt);
	}
	
 }
