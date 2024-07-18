package practice.responseValidation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class VerifyResponseTimeTest {

	@Test
	public void verifyTimeTest() {

		Response resp = given().get("http://49.249.28.218:8091/projects");

		resp.then().log().all();

		long respTime = resp.time();
		long respTimeInSeconds = resp.timeIn(TimeUnit.SECONDS);

		System.out.println(respTime);
		System.out.println(respTimeInSeconds);

		resp.then().assertThat().time(Matchers.lessThan(900L)); // Matcher class we use verify response time
		resp.then().assertThat().time(Matchers.greaterThan(200L));

		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(200L)));

	}

}
