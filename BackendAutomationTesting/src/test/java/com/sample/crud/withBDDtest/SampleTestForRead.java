package com.sample.crud.withBDDtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import groovy.util.logging.Log;


public class SampleTestForRead {
	
	@Test
	public void getDataFromServer() {
		
		given().get("http://49.249.28.218:8091/projects")
		.then().assertThat().statusCode(200)
		.log().all();
		
		
	
		
		
		
		
	}

}
