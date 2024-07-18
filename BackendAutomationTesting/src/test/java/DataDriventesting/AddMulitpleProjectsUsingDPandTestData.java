package DataDriventesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FileUtility.ExcelUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.lang.reflect.Executable;

public class AddMulitpleProjectsUsingDPandTestData {

	@Test(dataProvider = "getData")
	public void sampleTest(String projectName, String status) {

		String reqBody = "{\r\n" + "  \"createdBy\": \"Subham\",\r\n" + "  \"projectName\": \"" + projectName+ "\",\r\n" + "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 4\r\n" + "}";

		given().contentType(ContentType.JSON).body(reqBody)
		.when().post("http://49.249.28.218:8091/addProject").then().log().all();

	}

	@DataProvider

	public Object getData() throws Throwable {
		ExcelUtility elib = new ExcelUtility();
		int count = elib.getRowCount("projectData");
		
		
		Object[][] objArr = new Object[count][2];
		
		for(int i = 0; i<count; i++)
		{
			
			objArr[i][0] = elib.getDataFromExcel("projectData", i + 1, 0);
			objArr[i][1] = elib.getDataFromExcel("projectData", i + 1, 1);
			
		}


		return objArr;

	}

}
