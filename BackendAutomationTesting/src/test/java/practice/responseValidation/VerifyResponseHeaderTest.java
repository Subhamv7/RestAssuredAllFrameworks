package practice.responseValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseHeaderTest {

	@Test
	public void verifyHeader() {
		Response resp = given().get("http://49.249.28.218:8091/projects");
		resp.then().log().all();

		resp.then().assertThat().contentType(ContentType.JSON);
		
		resp.then().statusLine("HTTP/1.1 200 ");
		resp.then().assertThat().statusCode(200);
		resp.then().assertThat().header("Transfer-Encoding", "chunked");
		

	}
}
