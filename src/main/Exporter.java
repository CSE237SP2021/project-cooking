package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Exporter {
	
	public void export(String rawJSON) {
		JSONObject json = (JSONObject) JSONValue.parse(rawJSON);
		
		String contents = formatHTML(json);
		String filename = ((String)json.get("title")).toLowerCase().replace(' ', '_');
		
		if (writeToFile(filename, contents)) {
			System.out.println("Recipe output in " + filename + ".html");
		} else {
			System.out.println("Recipe output failed");
		}
	}
	
	// Helper method that takes in a JSONObject corresponding to a JSON recipe response from the WebKnox API
	// and returns a String corresponding to the HTML representation of that recipe.
	private String formatHTML(JSONObject json) {
		JSONArray ingredientsArray = (JSONArray) json.get("ingredients");
		String ingredients = "<ul>\n";
		for (int i = 0; i < ingredientsArray.size(); i++) {
			JSONObject ingr = (JSONObject) ingredientsArray.get(i);
			ingredients += "\t<li> " + ingr.get("original") + "</li>\n";
		}
		ingredients += "</ul>";
	
		return "<html>\n"
					+ "<body>\n"
					+ "<h1> " + json.get("title") + " </h1>\n"
					+ "<section id=ingredients>\n"
					+ "\t<h2> Ingredients </h2>\n"
					+ ingredients
					+ "</section>\n"
					+ "<section id=instructions>\n"
					+ "\t<h2> Instructions </h2>\n"
					+ json.get("instructions")
					+ "</section>\n"
					+ "</body>\n"
					+ "</html>";
		
	}
	
	// Helper method that outputs an .html file in the working directory given that file's name and contents. 
	// Returns true if the file was written to succesfully, false otherwise.
	private boolean writeToFile(String filename, String contents) {
		File outputFile = new File(filename + ".html");
		
		try {
			outputFile.createNewFile();
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
