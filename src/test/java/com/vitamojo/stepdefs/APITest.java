package com.vitamojo.stepdefs;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.vitamojo.framework.APIModel;
import com.vitamojo.pages.APIs;
import com.vitamojo.pages.CommonPOM;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;

public class APITest {
	
	APIs api = new APIs();
	APIModel res = null;
	
	@When("I call register API with invalid emails & verify the following details")
	public void i_call_register_api_with_invalid_emails_verify_the_following_details(List<Map<String, String>> rows) {
		for (Map<String, String> columns : rows) {
			APIModel model = api.register(CommonPOM.getData("dummyname"),
											columns.get("email"),
												CommonPOM.getData("dummypassword"));
			String expected = model.jsonpath.get("message[0].constraints[0]");
			assertThat(expected).isEqualTo(columns.get("errormessage"));
			assertThat(String.valueOf(model.statusCode)).isEqualTo(columns.get("responsecode"));
			assertThat(model.responsetime).isLessThan(Integer.parseInt(columns.get("responsetime")));
		}
	}

	@When("I call register API with invalid passwords & verify the following details")
	public void i_call_register_api_with_invalid_passwords_verify_the_following_details(List<Map<String, String>> rows) {
		for (Map<String, String> columns : rows) {
			APIModel model = api.register(CommonPOM.getData("dummyname"),
											CommonPOM.getData("dummyemail"), 
												columns.get("password"));
			String expected = model.jsonpath.get("message[0].constraints[0]");
			assertThat(expected).isEqualTo(columns.get("errormessage"));
			assertThat(model.statusCode).isEqualTo(Integer.parseInt(columns.get("responsecode")));
			assertThat(model.responsetime).isLessThan(Integer.parseInt(columns.get("responsetime")));
		}
	}

	@When("I call register API with existing <email> {string}")
	public void i_call_register_api_with_existing_email_data(String email) {
	    res = api.register(
				CommonPOM.getData("dummyname"), email,
				CommonPOM.getData("dummypassword"));
	}

	@Then("I verify response code is {int}")
	public void i_verify_response_code_is(Integer rescode) {
		assertThat(res.statusCode).isEqualTo(rescode);
	}

	@Then("I verify response time is less than {int}")
	public void i_verify_response_time_is_less_than(Integer time) {
		assertThat(res.responsetime).isLessThan(time);
	}

	@Then("I verify the error <message> {string}")
	public void i_verify_the_error_message(String msg) {
		String expected = res.jsonpath.get("message[0].constraints[0]");
		assertThat(expected).isEqualTo(msg);
	}

	@When("I call register API with a valid name, email & password")
	public void i_call_register_api_with_a_valid_name_email_password() {
	    // random email
		String email = "pritam" + ((new Random()).nextInt(900) + 100) + "@test.com";
		res = api.register(
				CommonPOM.getData("dummyname"), email,
				CommonPOM.getData("dummypassword"));
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Registered a new user with email :: " + email);
	}

	@Then("I verify the response body")
	public void i_verify_the_response_body() {
		assertThat(res.statusCode).isEqualTo(201);
		assertThat(res.responsetime).isLessThan(5000);
		String expected = res.jsonpath.get("payload.user.profile.firstName");
		assertThat(expected).isEqualTo(CommonPOM.getData("dummyname"));
	}
	
	@When("I call login API with invalid emails & verify the following details")
	public void i_call_login_api_with_invalid_emails_verify_the_following_details(List<Map<String, String>> rows) {
		for (Map<String, String> columns : rows) {
			APIModel model = api.login(columns.get("email"), columns.get("password"));
			assertThat(String.valueOf(model.statusCode)).isEqualTo(columns.get("responsecode"));
			assertThat(model.responsetime).isLessThan(Integer.parseInt(columns.get("responsetime")));
		}
	}

	@When("I call login API with invalid <email> {string} & valid <password> {string}")
	public void i_call_login_api_with_invalid_email_valid_password(String email, String password) {
		res = api.login(email, password);
	}
	
	@When("I call login API with valid <email> {string} & invalid <password> {string}")
	public void i_call_login_api_with_valid_email_invalid_password(String email, String password) {
		res = api.login(email, password);
	}

	@Then("I verify the response <message> as {string}")
	public void i_verify_the_response_message_as(String msg) {
		String expected = res.jsonpath.get("message");
		assertThat(expected).isEqualTo(msg);
	}

	@When("I call login API with valid <email> {string} & valid <password> {string}")
	public void i_call_login_api_with_valid_email_valid_password(String email, String password) {
		res = api.login(email, password);
	}
}
