package practice.responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class VerifyResponseBodyViaJSONPath {

	@Test
	public void VerifyResponseBodyTest() {

		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");

		resp.then().log().all();
		

		int data = resp.jsonPath().get("numberOfElements");
		System.out.println(data);
		
		resp.then().assertThat().body("numberOfElements", Matchers.equalTo(data));

		boolean data1 = resp.jsonPath().get("pageable.sort.unsorted");
		System.out.println(data1);
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(data1));
		
		String projectId = resp.jsonPath().get("content[0].projectId");
		System.out.println(projectId);
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo(projectId));
		
		
		ArrayList<String> projectList = resp.jsonPath().get("content.projectName");
		System.out.println(projectList);
		
		
	}

}
