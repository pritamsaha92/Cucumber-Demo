package com.vitamojo.framework;

import static io.restassured.RestAssured.given;

import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Pritam Saha
 *
 */

public class API extends Base {
	
	public static API getInstance() {
		return new API();
	}
	
	/** Method to GET Call 
	 * @param url
	 * @return
	 */
	public APIModel get(String url){
		try {
			Response res = given()
					.contentType("application/json")
					.when()
					.get(url);
			return new APIModel(res.getStatusCode(), 
					res.getTime(), 
					res.getSessionId(), 
					res.getCookies(), 
					res.getBody(), 
					res.jsonPath());
		} catch (Throwable th) {
			catchError(th);
		}
		return null;
	}
	
	/**
	 * Method to make a GET API call with header
	 * @param url
	 * @param header
	 * @return
	 */
	public APIModel get(String url, Headers headers){
		try {
			Response res = given()
					.contentType("application/json")
					.headers(headers)
					.when()
					.get(url);
			return new APIModel(res.getStatusCode(), 
					res.getTime(), 
					res.getSessionId(), 
					res.getCookies(), 
					res.getBody(), 
					res.jsonPath());
		} catch (Throwable th) {
			catchError(th);
		}
		return null;
	}


	/**
	 * Method to make a POST API call with payload
	 * @param url
	 * @param body
	 * @return
	 */
	 public APIModel post(String url, String  body){
		try {
			Response res = given()
					.contentType("application/json")
					.body(body.toString())
					.when()
					.post(url);
			return new APIModel(res.getStatusCode(), 
					res.getTime(), 
					res.getSessionId(), 
					res.getCookies(), 
					res.getBody(), 
					res.jsonPath());
		} catch (Throwable th) {
			catchError(th);
		}
		return null;
	 }

	/**
	 * Method to make a POST API call with payload and header
	 * @param url
	 * @param body
	 * @param headers
	 * @return
	 */
	 public APIModel post(String url, String body, Headers headers){
		 try {
			 Response res = given()
					 .contentType("application/json")
					 .headers(headers)
					 .body(body)
					 .when()
					 .post(url);
			 return new APIModel(res.getStatusCode(), 
					 res.getTime(), 
					 res.getSessionId(), 
					 res.getCookies(), 
					 res.getBody(), 
					 res.jsonPath());
		 } catch (Throwable th) {
			 catchError(th);
		 }
		 return null;
	 }
}
