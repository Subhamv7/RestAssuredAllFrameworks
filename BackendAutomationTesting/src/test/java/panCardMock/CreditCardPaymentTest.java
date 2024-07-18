package panCardMock;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CreditCardPaymentTest {
	
	@Test
	public void sampleTest() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("creditcard", "1234567891234");
		jObj.put("cvv", "123");
		jObj.put("cardName", "Subham");
		
		given()
		//.contentType(ContentType.JSON)
		.body(jObj)
		
		.when().post("http://localhost:8889/credit-card")
		.then().log().all();
		
		
		
		
		
	}
	

}
