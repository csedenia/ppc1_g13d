package Functions;

public class Input_checking {
	
	public static boolean date_checking(String input) { // for function B
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
			System.out.println("Input date is not a valid integer.");
			return false;
		}
	}
	
	public static boolean labor_capacity_checking(String input) { // for function A B C
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input labor capacity is not a valid integer.");
			return false;
		}
	}
	
	public static boolean grape_capacity_checking(String input) { // for function A B C
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input grape capacity is not a valid integer.");
			return false;
		}
	}
	
	public static boolean pr_checking(String input) { // for function A B C
		try {
			Float.parseFloat(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input price of rose is not a valid float.");
			return false;
		}
	}
	
	public static boolean pn_checking(String input) { // for function A B C
		try {
			Float.parseFloat(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input price of noir is not a valid float.");
			return false;
		}
	}
	
	public static boolean numweek_checking(String input) { // for function A
		try {
			int week = Integer.parseInt(input);
			if(week>=1 && week<=15) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input number of week is not a valid integer.");
			return false;
		}
	}
	
	public static boolean fixedCost_checking(String input) { // for function A
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input fixed cost is not a valid integer.");
			return false;
		}
	}
	
	public static boolean Rose_backOrder_checking(String input) { // for function C
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input fixed cost is not a valid integer.");
			return false;
		}
	}
	
	public static boolean Noir_backOrder_checking(String input) { // for function C
		try {
			Integer.parseInt(input);
			return true;
		}
		catch(NumberFormatException e){
			System.out.println("Input fixed cost is not a valid integer.");
			return false;
		}
	}
	
}
