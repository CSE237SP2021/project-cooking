package main;

public class InputFilter {

	public boolean yesNoFilter(String input) {
			
		switch(input) {
		case "y":
			return true;
		case "Y":
			return true;
		case "n":
			return true;
		case "N":
			return true; 
		default:
			return false;
		}
	}
	
}
