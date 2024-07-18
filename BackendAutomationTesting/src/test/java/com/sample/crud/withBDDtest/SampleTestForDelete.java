package com.sample.crud.withBDDtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class SampleTestForDelete {

	@Test
	public void deleteDataFromServer() {

		given().delete("http://49.249.28.218:8091/project/NH_PROJ_1302").then().assertThat().statusCode(204).log()
				.all();

	}

}
