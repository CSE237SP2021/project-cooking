package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.Controller;

class ControllerTests {

	@Test
	void searchByKeywordTest() {
		Controller testController = new Controller();
		String testKeyword = "burger";
		String result = testController.searchByKeyword(testKeyword);
		boolean isNull = result.isEmpty();
		assertFalse(isNull);
	}

}
