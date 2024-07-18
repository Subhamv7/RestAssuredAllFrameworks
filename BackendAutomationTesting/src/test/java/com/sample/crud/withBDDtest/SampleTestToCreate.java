package com.sample.crud.withBDDtest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleTestToCreate {

	@Test
	public void createData() {

		JSONObject jObj = new JSONObject();

		jObj.put("createdBy", "Subham");
		jObj.put("projectName", "Amazon_21");
		jObj.put("status", "Created");
		jObj.put("teamSize", "10");
		
		given ()
		.contentType(ContentType.JSON)
		.body(jObj.toJSONString())
		
		.when().post("http://49.249.28.218:8091/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.log().all();
		

	}

}
