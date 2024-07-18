package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {
	
	@Test
	public void sampleGetReqTest() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		
		System.out.println(res.prettyPrint());
 		
	}
}
