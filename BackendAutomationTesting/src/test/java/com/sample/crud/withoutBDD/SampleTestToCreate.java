package com.sample.crud.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestToCreate {
	
	@Test
	public void createData() {
		
		JSONObject jObj = new JSONObject();
		
		jObj.put("createdBy", "Subham");
		jObj.put("projectName", "Amazon_10");
		jObj.put("status", "Created");
		jObj.put("teamSize", "5");
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj.toJSONString());
		
		Response resp = req.post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);
		
	}

}
