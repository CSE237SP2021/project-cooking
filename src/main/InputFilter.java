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
	
	public boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e){
			return false;
		}
	
		
	}
	
}
