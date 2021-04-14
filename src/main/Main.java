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
			exporter.export(text);
			controller.continuePrompt();
		}
	}
}