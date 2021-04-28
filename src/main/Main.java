package main;

import java.io.*;


public class Main {
	
	public static Controller controller = new Controller();
	public static APIController aPIController = new APIController();
	public static Exporter exporter = new Exporter();

	public static void main(String[] args) throws IOException {
		String response = controller.initialize();
		if (response.equals("1")) {
			String text = aPIController.getRandomPopularRecipe();
			switch (exporter.export(text)) 
			{
				case success:
					System.out.println("...and we got it! You'll find it in the recipes folder :)");
					break;
				case parse_failure:
				case missing_fields_failure:
					System.out.println("...but there was an issue with it, so we weren't able to grab it for you. Sorry about that :(");
					break;
				case file_creation_failure:
					System.out.println("...but we had trouble making a new file for it, so it was lost. Sorry about that :(");
				default:
					System.out.println("...but we ran into some trouble, so it was lost. Sorry about that :(");
					break;
			}
			controller.continuePrompt();
		}
	}
}