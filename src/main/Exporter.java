package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Exporter {
	
	public enum returnCode {
		success, parse_failure, missing_fields_failure, file_creation_failure
	};
	
	// Takes in a String corresponding to the JSON recipe response from the WebKnox API and attempts to export
	// the name, ingredients, and instructions information from that recipe into a .html file. Returns true if the 
	// file is successfully made, false otherwise.
	public returnCode export(String rawJSON) {
		
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(rawJSON);
						
			String title = (String) json.get("title");
			String instructions = (String) json.get("instructions");
			JSONArray ingredientsArray = (JSONArray) json.get("ingredients");
			
			System.out.println("We found a good-looking recipe for " + title + " that we think you'll love...");
			
			if (title == null || instructions == null || ingredientsArray == null) {
				return returnCode.missing_fields_failure;
			}
			
			String ingredients = formatIngredients(ingredientsArray);
			
			String contents = "<html lang='en'>\n"
					+ "<head>\n"
					+ "<title> Recipe for " + title + " </title>\n"
					+ "<link rel='stylesheet' type='text/css' href='style.css'/>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "<h1> " + title + " </h1>\n"
					+ "<section id='ingredients'>\n"
					+ "<h2> Ingredients </h2>\n"
					+ ingredients + "\n"
					+ "</section>\n"
					+ "<section id='instructions'>\n"
					+ "<h2> Instructions </h2>\n"
					+ instructions + "\n"
					+ "</section>\n"
					+ "</body>\n"
					+ "</html>";

			String filename = title.toLowerCase().replace(' ', '_') + ".html";
			

			if (writeToFile(filename, contents)) {
				return returnCode.success;
			} else {
				return returnCode.file_creation_failure;
			}
	
		} 
		
		/* The call to parser.parse() on line 26 may throw a ParseException if rawJSON isn't a proper JSON object
		 * json.get("ingredients") on line 30 may throw a ClassCastException if the data value there
		 * isn't a proper JSON array. Since these errors are related, they return the same returnCode.
		 */
		catch (ParseException | ClassCastException e) {
			return returnCode.parse_failure;
		}
		
	}
	
	// Helper method that takes in a JSONArray corresponding to the array value tied to the 'ingredients'
	// property in a JSON recipe response form the WebKnox API, and returns the HTML representation
	// of those ingredients (a String).
	private String formatIngredients(JSONArray ingredientsArray) {
		
		String ingredients = "<ul>\n";
		boolean wasSkipped = false;
		
		for (int i = 0; i < ingredientsArray.size(); i++) {
			JSONObject ingr = (JSONObject) ingredientsArray.get(i);
			if (ingr.containsKey("original")) {
				ingredients += "\t<li> " + ingr.get("original") + "</li>\n";
			} else {
				wasSkipped = true;
			}
		}
		ingredients += "</ul>";
		
		if (wasSkipped) {
			System.out.println("Heads up! One or more of your ingredients may be missing from the list.");
		}
		return ingredients;
		
	}
	
	// Helper method that outputs an .html file in a subdirectory to the working directory, ./recipes, given that file's name and contents. 
	// Returns true if the file was written to succesfully, false otherwise.
	private boolean writeToFile(String filename, String contents) {
		
		try {
			File recipeDir = new File("./recipes");
			if (!recipeDir.exists()) {
				recipeDir.mkdir();
			}
			
			File outputFile = new File("./recipes/" + filename);
			if (!outputFile.createNewFile()) {
				return false;
			}
			
			File styleFile = new File("./recipes/style.css");
			if (!styleFile.exists()) {
				styleFile.createNewFile();
				FileWriter writer = new FileWriter(styleFile);
				writer.write("@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap');\n" + 
						"\n" + 
						"body {\n" + 
						"    background-color: #FAFAFA;\n" + 
						"    color: #1C1C1E;\n" + 
						"    font-family: 'Roboto', sans-serif;\n" + 
						"    width: 100%;\n" + 
						"    margin: 0;\n" + 
						"}\n" + 
						"\n" + 
						"h1 {\n" + 
						"  width: 100%;\n" + 
						"  background-color: #E0115F;\n" + 
						"  color: white;\n" + 
						"  text-align: center;\n" + 
						"}\n" + 
						"\n" + 
						"h2 {\n" + 
						"  text-decoration: underline;\n" + 
						"}\n" + 
						"\n" + 
						"section {\n" + 
						"  background-color: white;\n" + 
						"  width: 50%;\n" + 
						"  margin: auto;\n" + 
						"}" + 
						"}");
				writer.flush();
				writer.close();
			}
			
			FileWriter writer = new FileWriter(outputFile);
			writer.write(contents);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			return false;
		}
		return true;
		
	}
}
