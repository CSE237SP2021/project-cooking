package tests;

import main.Exporter;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;

public class ExporterTest {
		
	@Before
	@After
	public void deleteTempFile() {
		
		File tmp = new File("./recipes/cheesy_mac_and_cheese.html");
		if (tmp.canWrite()) {
			System.out.println("Deleted the temp file");
			tmp.delete();
		} else {
			System.out.println("Nothing to do");
		}
		
	}
	
	@Test
	public void testCaseParseFailure() {
		
		System.out.println("Testing for parse_failure...");
		
		Exporter exporter = new Exporter();
		String badInput = "[title: 'Three Cheese Soup'}";
		String badInput2 = "{\"title\": \"Cheesy Mac and Cheese\", \"ingredients\": 3, \"instructions\": \"1. Do it good\"}";

		
		assertTrue("Bracket mismatch", exporter.export(badInput) == Exporter.returnCode.parse_failure);
		assertTrue("Ingredients isn't a JSONArray", exporter.export(badInput2) == Exporter.returnCode.parse_failure);
		
		System.out.println();
	}
	
	@Test
	public void testCaseMissingFieldsFailure() {
		
		System.out.println("Testing for missing_fields_failure...");
		
		Exporter exporter = new Exporter();
		String badInput = "{\"title\": \"Cheesy Mac and Cheese\", \"instructions\": \"1. Do it good\"}";
		String badInput2 = "{\"title\": \"Cheesy Mac and Cheese\", \"ingredients\": [{\"original\" : \"cheese and mac\"}]}";
		String badInput3 = "{\"ingredients\": [{\"original\" : \"cheese and mac\"}], \"instructions\": \"1. Do it good\"}";
		String validInput = "{\"title\": \"Cheesy Mac and Cheese\", \"ingredients\": [{\"name\" : \"cheese and mac\"}], \"instructions\": \"1. Do it good\"}";
		
		assertTrue("Missing ingredients", exporter.export(badInput) == Exporter.returnCode.missing_fields_failure);
		assertTrue("Missing instructions", exporter.export(badInput2) == Exporter.returnCode.missing_fields_failure);
		assertTrue("Missing title", exporter.export(badInput3) == Exporter.returnCode.missing_fields_failure);
		assertTrue("Bad ingredients (should be skipped over and a message is printed)", exporter.export(validInput) == Exporter.returnCode.success);
		
		System.out.println();
		
	}
	
	@Test
	public void testCaseFileCreationFailure() {
		
		System.out.println("Testing for file_creation_failure...");
		
		Exporter exporter = new Exporter();
		String validInput = "{\"title\": \"Cheesy Mac and Cheese\", \"ingredients\": [{\"name\" : \"cheese and mac\"}], \"instructions\": \"1. Do it good\"}";
		
		assertTrue("First pass", exporter.export(validInput) == Exporter.returnCode.success);
		assertTrue("Duplicate file", exporter.export(validInput) == Exporter.returnCode.file_creation_failure);
		
		System.out.println();
		
	}

}