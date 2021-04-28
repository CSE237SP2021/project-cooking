package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.InputFilter;


public class InputFilterTest {

	@Test
	public void testYesNoFilter() {
		InputFilter inFilter = new InputFilter();
		
		String yLower = "y";
		String yUpper = "Y";
		String nLower = "n";
		String nUpper = "N";
		
		String malformedInput = "fhdasjkdfahjf";
		String numbers = "123";
		String space = " ";
		
		assertTrue("Lower case y returns true", inFilter.yesNoFilter(yLower) == true);
		assertTrue("Upper case y returns true", inFilter.yesNoFilter(yUpper) == true);
		assertTrue("Lower case n returns true", inFilter.yesNoFilter(nLower) == true);
		assertTrue("Upper case n returns true", inFilter.yesNoFilter(nUpper) == true);
		assertTrue("Malformed input returns false", inFilter.yesNoFilter(malformedInput) == false);
		assertTrue("numbers returns false", inFilter.yesNoFilter(numbers) == false);
		assertTrue("space returns false", inFilter.yesNoFilter(space) == false);
	}
	
	@Test 
	public void testIsNumber() {
		InputFilter inFilter = new InputFilter();
		
		String input1 = "30303";
		String input2 = "^_^";
		String input3 = " 3 ";
		
		assertTrue("Input one is a number", inFilter.isNumber(input1) == true);
		assertTrue("Input two is not a number", inFilter.isNumber(input2) == false);
		assertTrue("Input three is not a well formed number", inFilter.isNumber(input3) == false);
	}
	
}
