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
	APIController aPIController;
	Exporter exporter;
	RecipeOutputter recipeOutputter;
	
	public Controller() {
		scanner = new Scanner(System.in);
		inputFilter = new InputFilter();
		aPIController = new APIController();
		exporter = new Exporter();
		recipeOutputter = new RecipeOutputter();
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
		
		String text;
		switch(response) {
			case("h"): //print commands
				commandOptions();
				return selectAction();
			case("1"): //search for random recipe
				System.out.println("Searching for a random recipe... ");
				text = aPIController.getRandomPopularRecipe();
				exporter.export(text);
				break;
			case("2"): //call search by term method here
				System.out.println("Type a keyword to search for a recipe you're interested in");
				String keywordInput = scanner.nextLine();
				System.out.println("Searching for your recipe...");
				aPIController.searchByKeyword(keywordInput);
				break;
			case("3"): //call search by ingredient method here
				System.out.println("Type a keyword to search for a recipe with an ingredient you're interested in");
				String ingredientInput = scanner.nextLine();
				System.out.println("Searching for recipes with the ingredient you specified...");
				aPIController.searchByIngredient(ingredientInput);
				break;
			case("4"):
				System.out.println("Checking to see what recipes are available...");
				recipeOutputter.viewOutputOfFile();
				break;
			default:
				System.out.println("That doesn't look like a suggestion. Please check your spelling and try again.");
				selectAction();
		}
		continuePrompt();
	
		return response;
	}
	
	public void commandOptions() {
		System.out.println("Press 1 to roll a random recipe.");
		System.out.println("Press 2 to search for a specific recipe.");
		System.out.println("Press 3 to search for a recipe by ingredient.");
		System.out.println("Press 4 to print a recipe to the console.");
	}
	
	public void continuePrompt() {
		System.out.println("Would you like to try something else? (Y/N) ");
		String response = scanner.nextLine();
		if (!inputFilter.yesNoFilter(response)) {
			System.out.println("Please check your spelling and try again.");
			continuePrompt();
		} 
		
		if (response.toLowerCase().equals("y")) {
			selectAction();
		} else {
			System.out.println("Thanks for using our app!");
		}
	
	}

}
