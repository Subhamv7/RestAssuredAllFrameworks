package com.sample.crud.withBDDtest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleTestToUsingPatch {

	@Test
	public void partialUpdateUsingPatch() {

		JSONObject jObj = new JSONObject();

		jObj.put("projectName", "Amazon_23");
		
		
		given ()
		.contentType(ContentType.JSON)
		.body(jObj.toJSONString())
		
		.when().patch("http://49.249.28.218:8091/project/NH_PROJ_1302")
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
		

	}

}
