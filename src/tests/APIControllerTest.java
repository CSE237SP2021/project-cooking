package tests;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import main.APIController;

public class APIControllerTest {
	
	@Test
	void searchByKeywordTest() {
		APIController testController = new APIController();
		String testKeyword = "burger";
		String result = testController.searchByKeyword(testKeyword);
		boolean isNull = result.isEmpty();
		assertFalse(isNull);
	}
	
	@Test
	public void searchByIngredientsTest() {
		APIController testController = new APIController();
		String testIngredient = "banana"; //random ingredient to search with
		String result = testController.searchByIngredient(testIngredient);
		boolean isNull = result.isEmpty();
		assertFalse(isNull);
	}
}
