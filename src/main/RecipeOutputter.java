package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Desktop;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

// sources: 
// https://javarevisited.blogspot.com/2014/09/how-to-parse-html-file-in-java-jsoup-example.html
// https://stackabuse.com/java-list-files-in-a-directory/
public class RecipeOutputter {
	
	File recipeDir;
	InputFilter inputFilter;
	String[] files;
	Scanner scanner;
	
	public RecipeOutputter() {
		recipeDir = new File("./recipes");
		files = getFilesInDir(recipeDir);
		scanner = new Scanner(System.in);
		inputFilter = new InputFilter();
	}
	
	
	public String[] getFilesInDir(File directory) {
		String[] allFiles = directory.list((d,s) -> {
			return s.toLowerCase().endsWith(".html");
		});
		return allFiles;
	}

	public void viewOutputOfFile() {
		File targetFile = new File("./recipes/" + selectRecipe());
		Desktop desktop = Desktop.getDesktop();
		
		try {
			if (!targetFile.exists()) {
				System.out.println("Uh oh. Looks like the file got deleted somehow. Weird.");
				return;
			}
			if (Desktop.isDesktopSupported()) {
				desktop.open(targetFile);
			} else {
				printRecipe(targetFile);
			}
		} catch (IOException e) {
			System.out.println("Darn. Looks like we're having trouble opening that file. Try again some other time.");
		}
	}
	
	public File getRecipeDir() {
		return recipeDir;
	}
	
	public void getAvailableRecipeNames() {
		files = getFilesInDir(recipeDir);
		for (int i = 0; i < files.length; ++i) {
			System.out.println(i + ": " + files[i]);
		}
	}
	
	//method to allow user to pick which recipe
	public String selectRecipe() {
		System.out.println("Type in the number corresponding to the recipe file you'd like to view");
		System.out.println("Here are the available recipe files: ");
		getAvailableRecipeNames();
		
		String userResponse = scanner.nextLine();
		int index = 0;
		if (inputFilter.isNumber(userResponse)) {
			index = Integer.parseInt(userResponse);
		} else {
			System.out.println("Sorry, your input wasn't a valid number!");
			selectRecipe();
		}
		
		if (index > (files.length - 1)) {
			System.out.println("Error, you picked a index that's too high.");
			selectRecipe();
		}
		
		String fileName = files[index];
		return fileName;
	}
	
	//method to print that recipe file to console, UI method
	public void printRecipe(File f) throws IOException {
		Document doc = Jsoup.parse(f, "UTF-8", "");
		System.out.println(doc.toString());
	}
}
