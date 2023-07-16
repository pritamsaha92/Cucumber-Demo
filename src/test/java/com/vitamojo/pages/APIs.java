package com.vitamojo.pages;

import com.vitamojo.framework.API;
import com.vitamojo.framework.APIModel;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class APIs {
	
	static Header header = new Header("Tenant", CommonPOM.getData("tenant"));
	
	public APIModel login(String email, String password) {
		String url = CommonPOM.getData("login_end_point");
		String body = "{\n"
		 		+ "    \"firstName\": \"pppd\",\n"
		 		+ "    \"email\": \""+ email +"\",\n"
		 		+ "    \"password\": \""+ password +"\",\n"
		 		+ "    \"marketing\": false\n"
		 		+ "}";
		Headers headers = new Headers(header);
		return API.getInstance().post(url, body, headers);
	}
	
	public APIModel register(String name, String email, String password) {
		String url = CommonPOM.getData("register_end_point");
		String body = "{\n"
				+ "    \"profile\": {\n"
				+ "        \"firstName\": \""+ name +"\"\n"
				+ "    },\n"
				+ "    \"email\": \"" + email+ "\",\n"
				+ "    \"password\": \"" + password + "\",\n"
				+ "    \"locale\": \"en-GB\"\n"
				+ "}";
		Headers headers = new Headers(header);
		return API.getInstance().post(url, body, headers);
	}
}
