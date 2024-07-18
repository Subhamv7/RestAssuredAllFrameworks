package panCardMock;

import com.jayway.jsonpath.JsonPath;

import spark.Spark;

public class CreditCardMock {

	public static void main(String[] args) {

		// Spark mocking solution

		Spark.port(8889);
		Spark.post("/credit-card", (req, res) -> {

			String response = "";

			String card = JsonPath.read(req.body().toString(), "$.creditcard");
			
			
			
			if (org.apache.commons.lang3.StringUtils.equalsAny(card, "1234567891234" , "12345678912345")) {
				response = "{\"status\":\"Payment success\"}";
				res.status(200);

			} else {
				response = "{\"status\":\"Payment failed\"}";
				res.status(404);
			}
			
			res.type("application/Json");
			

			return response;

		});
		
		System.out.println("Running");

	}

}
