package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoClass.EmployeePojo;
import PojoClass.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenerio_2_AddEmployeeToProject {

	@Test
	public void postDataToServer() {

		// Create an object to POJO class
		Random ran = new Random();
		int randomNum = ran.nextInt(5000);

		//API 1 - Add a project in side server
		ProjectPojo pObj = new ProjectPojo("Jio_" + randomNum, "Created", "Subham", 10);

		Response resp = given().contentType(ContentType.JSON).body(pObj)

		.when().post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201)
		.and().assertThat().body("msg", Matchers.equalTo("Successfully Added"))
		.log().all();

		// Capture projectID from the response
		String projectName = resp.jsonPath().get("projectName");
		System.out.println(projectName);

		// API 2 - Add emp to same project
		EmployeePojo empObj = new EmployeePojo("Architect" , "26/08/1997" , "subham@gmail.com" , 
		"Subham_"+randomNum , 5 , "9876876589" , projectName , "ROLE_EMPLOYEE" , "Subham_"+randomNum );
		
		given().contentType(ContentType.JSON).body(empObj)
		.when().post("http://49.249.28.218:8091/employees")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		

	}

}
