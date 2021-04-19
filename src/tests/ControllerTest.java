package tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import main.Controller;

public class ControllerTest {
	
	@Test
	public void searchByIngredientsTest() {
		Controller testController = new Controller();
		String testIngredient = "banana"; //random ingredient to search with
		String result = testController.searchByIngredient(testIngredient);
		boolean IsNull = result.isEmpty();
		assertFalse(IsNull);
		
		
	}
}
