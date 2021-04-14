package tests;

import static org.junit.Assert.assertTrue;

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
	
	final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
	final PrintStream systemOut = System.out;
//	final PrintStream systemErr = System.out;
	
	@BeforeEach 
	public void setup() {
		System.setOut(new PrintStream(outputStream));
	}
	
//	@Test
//	public void testInitialize() {
//		Controller controller = new Controller();
//		
//		controller.initialize();
//		
//		System.out.println(outputStream.toString());
//		
//		assertTrue("Output is expected", outputStream.toString().equals("Hello, welcome to the cooking app!"));
//		
//		System.out.println("debuggy");
//		
//	}
	
	@Test
	public void testSelectAction() {
		Controller controller = new Controller();
		
		InputStream sysInBackup = System.in; // backup System.in to restore it later
		ByteArrayInputStream in = new ByteArrayInputStream("h".getBytes());
		System.setIn(in);
		
		controller.selectAction();
		
		
		
	}
	
	@AfterEach
	public void resetOutput() {
	    System.setOut(systemOut);
	}

}
