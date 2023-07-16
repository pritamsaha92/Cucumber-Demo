package com.vitamojo.stepdefs;

import java.util.Random;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.vitamojo.framework.Base;
import com.vitamojo.pages.AuthPOM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration {

	AuthPOM auth = new AuthPOM();
	
	@When("I navigate to registration tab")
	public void i_navigate_to_registration_tab() {
	    auth.switchToRegistrationTab();	
	}

	@Then("I verify loyalty card")
	public void i_verify_loyalty_card() {
	    auth.verifyLoyaltyCard();
	}

	@Then("I verify page <header> {string}")
	public void i_verify_page_header(String string) {
	    auth.verifyPageheader("Create your account");
	}

	@And("I validate blank name error <message> as {string}")
	public void i_validate_blank_name_error_message(String msg) {
	    auth.validateNameErrorMsg(msg);
	}

	@When("I enter an existing <email> {string} and <name> {string}")
	public void i_enter_an_existing_email_and_name(String email, String name) {
	    auth.updateName(name);
	    auth.updateEmail(email);
	    auth.updatePassword(Base.getData("dummypassword"));
	    auth.clickAuthBtn();
	}

	@Then("I verify the alert <message> {string}")
	public void i_verify_the_alert_message(String msg) {
		auth.verifyAlert(msg);
	}

	@Then("I register a user with random email, name and password")
	public void i_register_a_user_with_random_email_name_and_password() {
	   String email = "pritam" + ((new Random()).nextInt(900) + 100) + "@test.com";
	   auth.updateName(Base.getData("dummyname"));
	   auth.updateEmail(email);
	   auth.updatePassword(Base.getData("dummypassword"));
	   auth.clickAuthBtn();
	   ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Registered a new user with email :: " + email);
	}

	@Then("I should be logged in and verify username")
	public void i_should_be_logged_in_and_verify_username() {
	   auth.verifySuccessfulLogin(Base.getData("dummyname"));
	}
	
	// Other Page Stepdefs 
	
	@When("I navigate to privacy policy page")
	public void i_navigate_to_privacy_policy_page() {
	    auth.navigateToPrivacy();
	}

	@When("I verify privacy policy page header {string}")
	public void i_verify_privacy_policy_page_header(String header) {
	    auth.verifyPrivacyHeader(header);
	}

	@When("I navigate to terms page")
	public void i_navigate_to_terms_page() {
	    auth.navigateToTerms();
	}

	@When("I verify terms page header {string}")
	public void i_verify_terms_page_header(String header) {
	    auth.verifyTermsHeader(header);
	}
}
