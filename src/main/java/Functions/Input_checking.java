package Functions;

public class Input_checking {
	
	public static boolean date_checking(String input) {
		try {
			int date = Integer.parseInt(input);
			if(date<=2315 && date>=2301) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input is not a valid integer.");
			return false;
		}
	}
	
}
