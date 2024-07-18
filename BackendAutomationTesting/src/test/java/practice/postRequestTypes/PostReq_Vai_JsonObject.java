package practice.postRequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PostReq_Vai_JsonObject {
	
	@Test
	public void postDataToServer() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("CreatedBy", "Subham");
		jObj.put("status", "Created");
		jObj.put("teamSize", 10);
		jObj.put("projectName", "Apple_1");
		
		given().contentType(ContentType.JSON)
		.body(jObj.toJSONString())
		.when()
		.post();
		
		
		
	}

	

}
