package main;

import java.io.*;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;


public class Main {
	
	public static Controller controller = new Controller();
	public static APIController aPIController = new APIController();

	public static void main(String[] args) throws IOException {
		String response = controller.initialize();
		if (response.equals("Y")) {
			String text = aPIController.getRandomPopularRecipe();
			JSONObject json = (JSONObject) JSONValue.parse(text);
			
			// Format the list of ingredients as HTML
			JSONArray ingredientsArray = (JSONArray) json.get("ingredients");
			String ingredients = "<ul>\n";
			for (int i = 0; i < ingredientsArray.size(); i++) {
				JSONObject ingr = (JSONObject) ingredientsArray.get(i);
				ingredients += "\t<li> " + ingr.get("original") + "</li>\n";
			}
			ingredients += "</ul>";

			String html = "<html>\n"
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
			String filename = ((String)json.get("title")).toLowerCase().replace(' ', '_');
			
			File outputFile = new File(filename + ".html");
			outputFile.createNewFile();
			FileWriter writer = new FileWriter(outputFile);
			writer.write(html);
			writer.flush();
			writer.close();
			System.out.println("Recipe output in " + filename + ".html");
		}
//		aPIController.GetRandomPopularRecipe();
	}
}