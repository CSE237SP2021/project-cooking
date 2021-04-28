package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.RecipeOutputter;

public class RecipeOutputterTest {
	
	
	@Test
	public void testGetFilesInDir() {
		RecipeOutputter ro = new RecipeOutputter();
		File testFileDir = new File("./testfiles");
		
		String[] availableRecipes = ro.getFilesInDir(testFileDir);
		
		assertTrue("Number of available recipes matches what's in the testfiles folder", availableRecipes.length == 4);	
	}
	
	@Test
	//This method uses user input so we will pass in indeces to verify that the file names are properly outputted.
	public void testSelectRecipe() {
		RecipeOutputter ro = new RecipeOutputter();
		File testFileDir = new File("./testfiles");
		String[] availableRecipes = ro.getFilesInDir(testFileDir);
		for (String s : availableRecipes) {
			System.out.println(s);
		}
		assertTrue("Name of the first file is testfile_1.html", availableRecipes[0].equals("testfile_1.html"));
		assertTrue("Name of the second file is testfile_3.html", availableRecipes[1].equals("testfile_3.html"));
		assertTrue("Name of the third file is testfile_2.html", availableRecipes[2].equals("testfile_2.html"));
		assertTrue("Name of the fourth file is testfile_4.html", availableRecipes[3].equals("testfile_4.html"));
	}
	
	@Test
	//The printRecipe is a UI related method so this test will test the html parsing component included in the class. 
	public void testFilePrinting() {
		RecipeOutputter ro = new RecipeOutputter();
		String fileName = "testfile_4.html";
		String targetFilePath = "./testfiles/" + fileName;
		File targetFile = new File(targetFilePath);
		String parsedBody = "Hello I am a testfile acquired by jsoup parsing.";
		
		
		try {
			Document doc = Jsoup.parse(targetFile, "UTF-8", "");
			Elements body = doc.select("body");
			assertTrue("Recipe document was parsed and contains the correct body.", body.toString().contains(parsedBody));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
