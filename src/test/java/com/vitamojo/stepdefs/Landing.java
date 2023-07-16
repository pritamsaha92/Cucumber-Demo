package com.vitamojo.stepdefs;

import com.vitamojo.pages.LandingPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landing {
	
	LandingPOM landing = new LandingPOM();
	
	@Given("I am on Fego Home Page")
	public void i_am_on_fego_home_page() throws Throwable {
	    landing.loadPortal();
	}
	
	@When("I click on the login button")
	public void i_click_on_the_login_button() throws Throwable {
	    landing.navigateToAuth();
	}

	@Then("I should be navigated to authentication page")
	public void i_should_be_navigated_to_authentication_page() throws Throwable {
	    landing.verifyAuthPage();	
	}
	
	@When("I am on Fego Login Page")
	public void i_am_on_fego_login_page() {
		landing.verifyPageheader("Login");
	}
}
