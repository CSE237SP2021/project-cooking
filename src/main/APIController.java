package main;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIController {
	
	public String getRandomPopularRecipe() {
		
		RestAssured.baseURI = "http://webknox.com/api/recipes";
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/randomPopular");
		
		String responseBody = response.getBody().asString();
		return responseBody;
	}
	
	public void GetRandomRecipe(int limit) {
		
		RestAssured.baseURI = "http://webknox.com/api/recipes";
		String apiKey = "bgbghcgbgjukoguhcldfqdvmhrctifm"; //Vishesh API key
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/randomPopular");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}
	
	public String searchByKeyword(String keywordInput) {
		//call the actual search method here 
		RestAssured.baseURI = "http://webknox.com/api/recipes";
		String apiKey = "48ec8d46512e4c03a4d2c18b015d64af"; //Aidan API key
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/complexSearch?apiKey=" + apiKey + "&query=" + keywordInput);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		return responseBody;
	}
	
	public String searchByIngredient(String ingredientInput) {
		RestAssured.baseURI = "http://webknox.com/api/recipes";
		String apiKey = "48ec8d46512e4c03a4d2c18b015d64af"; //Aidan API key
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/findByIngredients?apiKey=" + apiKey + "&ingredients=" + ingredientInput);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		return responseBody;
	}

}
