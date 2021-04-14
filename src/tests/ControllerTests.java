package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

class ControllerTests {

	@Test
	void searchByKeywordTest() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/complexSearch?query=");
		String result = response.getBody().asString();
		boolean isNull = result.isEmpty();
		assertFalse(isNull);
	}

}
