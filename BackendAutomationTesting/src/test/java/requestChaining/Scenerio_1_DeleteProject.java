package requestChaining;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import PojoClass.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenerio_1_DeleteProject {

	@Test
	public void postDataToServer() {

		Random ran = new Random();
		int randomNum = ran.nextInt(5000);

		ProjectPojo pObj = new ProjectPojo("Jio_" + randomNum, "Created", "Subham", 10);

	Response resp = given().contentType(ContentType.JSON).body(pObj)

				.when().post("http://49.249.28.218:8091/addProject");
			resp.then().assertThat().statusCode(201).log().all();
			
			// Capture project name from the response
			
			String projectId = resp.jsonPath().get("projectId");
			System.out.println(projectId);
			
			
			//Api - 2 Delete project
			given().delete("http://49.249.28.218:8091/project/"+projectId)
			.then().log().all();
			
			
			

	}

}
