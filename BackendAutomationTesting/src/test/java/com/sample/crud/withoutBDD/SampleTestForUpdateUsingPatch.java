package com.sample.crud.withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForUpdateUsingPatch {
	
	@Test
	public void updateDataUsingPatchTest() {
	

	JSONObject jObj = new JSONObject();
	
	jObj.put("projectName", "Amazon_13");
	
	
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jObj.toJSONString());
	
	Response resp = req.patch("http://49.249.28.218:8091/project/NH_PROJ_1270");
	resp.then().log().all();
	 resp.then().assertThat().statusCode(200);
	
	}

}
