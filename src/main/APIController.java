package main;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIController {
	
	public void getRandomPopularRecipe() {
		
		RestAssured.baseURI = "http://webknox.com/api/recipes";
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/randomPopular");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}
	
	public void GetRandomRecipe(int limit) {
		
		RestAssured.baseURI = "http://webknox.com/api/recipes";
		String apiKey = "bgbghcgbgjukoguhcldfqdvmhrctifm"; //Vishesh API key
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/randomPopular");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}
	
}
