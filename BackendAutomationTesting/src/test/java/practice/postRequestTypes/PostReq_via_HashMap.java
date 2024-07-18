package practice.postRequestTypes;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PostReq_via_HashMap {
	
	@Test
	public void postDataToServer() {
		
		HashMap<String, Object> map = new JSONObject();
		
		map.put("createdBy", "Subham");
		map.put("status", "Created");
		map.put("teamSize", 10);
		map.put("projectName", "Slice");
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://49.249.28:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
	

}
