package practice;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;

public class SampleTestUsingMethodChainingTest {
	
	@Test
	
	public void getRequestTest() {
		
		get("https://reqres.in/api/users/2")
		
		.then()
		.log()
		.all();
	}

}
