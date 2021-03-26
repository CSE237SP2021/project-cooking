package main;
import java.util.Scanner;


/**
 * Class that handles logic for user input and displaying menu options
 */
public class Controller {
	
	Scanner scanner;
	
	public Controller() {
		scanner = new Scanner(System.in);
	}
	
	public String initialize() {
		System.out.print("Hello, welcome to the cooking app! ");
		System.out.println("Would you like to roll a random recipe? (Y/N)");
		
		return randomRecipePrompt();
		
	}
	
	public String randomRecipePrompt() {
		String randomRecipeRes = scanner.nextLine();
		System.out.println("You chose " + randomRecipeRes);
		if (randomRecipeRes.equals("Y")) {
			return randomRecipeRes;
		}
		
		return null;
	}

}
