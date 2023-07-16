package com.vitamojo.framework;

import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

/**
 * @author Pritam Saha
 *
 */

public class APIModel {
	public int statusCode;
	public long responsetime;
	public String sessionid;
	public Map<String, String> cookies;
	public JsonPath jsonpath;
	public ResponseBody<?> resbody;

	APIModel(int statusCode,
			long responsetime, 
			String sessionid, 
			Map<String, String> cookies,
			ResponseBody<?> resbody,
			JsonPath jp) {
		this.statusCode = statusCode;
		this.responsetime = responsetime;
		this.sessionid = sessionid;
		this.cookies = cookies;
		this.jsonpath = jp;
		this.resbody = resbody;
	}
}
