package practice.responseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyResponseBodyTest {
	
	@Test
	
	public void verifyResponseBody() {
		
		Response resp = given().get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		resp.then().assertThat();
		
		
	}

}
