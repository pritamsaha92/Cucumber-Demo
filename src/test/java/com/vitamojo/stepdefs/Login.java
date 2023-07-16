package com.vitamojo.stepdefs;

import java.util.List;
import java.util.Map;

import com.vitamojo.pages.AuthPOM;
import com.vitamojo.pages.LandingPOM;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	AuthPOM auth = new AuthPOM();
	LandingPOM landing = new LandingPOM();
	String errorMsg;
	
	@DataTableType(replaceWithEmptyString = "[blank]")
    public String nullToString(String cell) {
//		String out = Objects.isNull(cell) ? StringUtils.EMPTY : cell;
//		System.out.println("Value is : " + cell + " & is empty " + cell.isEmpty());
		return cell;
	}
	
	@Then("I validate emailerror for followings")
	public void i_validate_emailerror_for_email(List<Map<String, String>> rows) {
		for (Map<String, String> columns : rows) {
			auth.updateEmail(columns.get("email"));
			auth.validateEmailErrorMsg(columns.get("emailerror"));
		}
	}
	
	@And("I validate passworderror for followings")
	public void i_validate_passworderror_for_password(List<Map<String, String>> rows) {
		for (Map<String, String> columns : rows) {
			auth.updatePassword(columns.get("password"));
			auth.validatePasswordErrorMsg(columns.get("passworderror"));
		}
	}
	
	@Then("I validate alert for following details")
	public void i_validate_alert_for_following_details(List<Map<String, String>> rows) {
		for (Map<String, String> columns : rows) {
			auth.updateEmail(columns.get("email"));
			auth.updatePassword(columns.get("password"));
			auth.clickAuthBtn();
			auth.verifyAlert(columns.get("alert"));
		}
	}
	
	@When("I fill in <email> with {string}")
	public void i_fill_in_email_with(String email) {
	   auth.updateEmail(email);
	}

	@And("I fill in <password> with {string}")
	public void i_fill_in_password_with(String password) {
	    auth.updatePassword(password);
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
	    auth.clickAuthBtn();
	}

	@Then("I should be logged in with <username> {string}")
	public void i_should_be_logged_in_with(String username) {
	    auth.verifySuccessfulLogin(username);
	}
	
	// Other Page Steps 
	
	@When("I navigate to forgot password page")
	public void i_navigate_to_forget_password_page() {
	    auth.navigatetoForgotPasswordPage();
	}

	@Then("I verify header {string}")
	public void i_verify_header(String header) {
	    auth.verifyForgotPasswordHeader(header);
	}

	@Then("I verify message {string}")
	public void i_verify_message(String msg) {
	    auth.verifyForgotPasswordText(msg);
	}

	@Then("I verify reset link button & text {string}")
	public void i_verify_reset_link_button_text(String btnText) {
	    auth.verifyResetBtn(btnText);
	}

	@Then("I navigate to previous page")
	public void i_navigate_to_login_page() {
	    auth.returnToLogin();
	}
}
