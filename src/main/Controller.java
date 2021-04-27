package main;
import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 * Class that handles logic for user input and displaying menu options
 */
public class Controller {
	
	Scanner scanner;
	InputFilter inputFilter;
	
	public Controller() {
		scanner = new Scanner(System.in);
		inputFilter = new InputFilter();
	}
	
	public String initialize() {
		System.out.println("Hello, welcome to the cooking app!");
		System.out.println("Simply type in the letter 'h' if you would like to see available commands.");
		
		return selectAction();
	}
	
	public String selectAction() {
		System.out.println("What would you like to do?");
		String response = scanner.nextLine();
		System.out.println("You typed " + response);
		switch(response) {
			case("h"): //print commands
				commandOptions();
				return selectAction();
			case("1"): //search for random recipe
				System.out.println("Searching for a random recipe... ");
				//call the code that's currently written in main as its own method here
				break;
			case("2"): //call search by term method here
				String keywordInput = scanner.nextLine();
				callSearchByKeyword(keywordInput);
				System.out.println("Searching for your recipe: ");
				break;
			case("3"): //call search by ingredient method here
				String ingredientInput = scanner.nextLine();
				callSearchByIngredient(ingredientInput);
				System.out.println("Searching for recipes with the ingredient you specified: ");
				break;
			default:
				System.out.println("Invalid selection, please check your spelling and try again.");
				selectAction();
		}
		
		return response;
	}
	
	public String callSearchByKeyword(String keywordInput) { 
		APIController searcher = new APIController();
		return searcher.searchByKeyword(keywordInput);
	}
	
	public String callSearchByIngredient(String ingredientInput) {
		APIController searcher = new APIController();
		return searcher.searchByIngredient(ingredientInput);
	}
	
	public void commandOptions() {
		System.out.println("Press 1 to roll a random recipe.");
		System.out.println("Press 2 to search for a specific recipe.");
		System.out.println("Press 3 to search for a recipe by ingredient.");
	}
	
	public void continuePrompt() {
		System.out.println("Would you like to try something else? (Y/N) ");
		String response = scanner.nextLine();
		if (!inputFilter.yesNoFilter(response)) {
			System.out.println("Please check your spelling and try again.");
			continuePrompt();
		} 
		
		if (response.equals("Y")) {
			selectAction();
		} else {
			System.out.println("Thanks for using our app!");
		}
	
	}

}
