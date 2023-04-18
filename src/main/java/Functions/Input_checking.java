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
	
	public static boolean labor_capacity_checking(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input is not a valid integer.");
			return false;
		}
	}
	
	public static boolean grape_capacity_checking(String input) {
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input is not a valid integer.");
			return false;
		}
	}
	
	public static boolean pr_checking(String input) {
		try {
			Float.parseFloat(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input is not a valid float.");
			return false;
		}
	}
	
	public static boolean pn_checking(String input) {
		try {
			Float.parseFloat(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input is not a valid float.");
			return false;
		}
	}
	
}
