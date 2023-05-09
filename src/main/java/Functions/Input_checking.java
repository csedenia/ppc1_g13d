/**
 * Program Code for Input_checking
 * @author Hardy, Fan Tsz Ho
 */
package Functions;

public class Input_checking {
	
	/**
	 * Function for Week Number Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Week Number being valid
	 */
	public static boolean date_checking(String input) { // for function B
		try {
			int date = Integer.parseInt(input);
			if(date<=2315 && date>=2301) {
				return true;
			}
			else {
				System.out.println("Input date should in range 2301 to 2315");
				return false;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input date is not a valid integer.");
			return false;
		}
	}
	
	/**
	 * Function for Labor Capacity Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Labor Capacity being valid
	 */
	public static boolean labor_capacity_checking(String input) { // for function A B C
		try {
			int int_num = Integer.parseInt(input);
			if(int_num < 0) {
				System.out.println("Input capacity is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input labor capacity is not a valid integer.");
			return false;
		}
	}
	
	/**
	 * Function for Grape Capacity Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Grape Capacity being valid
	 */
	public static boolean grape_capacity_checking(String input) { // for function A B C
		try {
			int int_num = Integer.parseInt(input);
			if(int_num < 0) {
				System.out.println("Input capacity is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input grape capacity is not a valid integer.");
			return false;
		}
	}
	
	/**
	 * Function for Price of Ros� Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Price of Ros� being valid
	 */
	public static boolean pr_checking(String input) { // for function A B C
		try {
			float float_num = Float.parseFloat(input);
			if(float_num < 0) {
				System.out.println("Input price is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input price of rose is not a valid float.");
			return false;
		}
	}
	
	/**
	 * Function for Price of Noir Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Price of Noir being valid
	 */
	public static boolean pn_checking(String input) { // for function A B C
		try {
			float float_num = Float.parseFloat(input);
			if(float_num < 0) {
				System.out.println("Input price is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input price of noir is not a valid float.");
			return false;
		}
	}
	
	/**
	 * Function for Number of Weeks Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Number of Weeks being valid
	 */
	public static boolean numweek_checking(String input) { // for function A
		try {
			int week = Integer.parseInt(input);
			if(week>=1 && week<=15) {
				return true;
			}
			else {
				System.out.println("Input number of week should in range 1-15.");
				return false;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input number of week is not a valid integer.");
			return false;
		}
	}
	
	/**
	 * Function for Fixed Cost Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Fixed Cost being valid
	 */
	public static boolean fixedCost_checking(String input) { // for function A
		try {
			int int_num = Integer.parseInt(input);
			if(int_num < 0) {
				System.out.println("Input fixed cost is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input fixed cost is not a valid integer.");
			return false;
		}
	}
	
	/**
	 * Function for Backorder Volume for Ros� Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Backorder Volume for Ros� being valid
	 */
	public static boolean Rose_backOrder_checking(String input) { // for function C
		try {
			int int_num = Integer.parseInt(input);
			if(int_num < 0) {
				System.out.println("Input backorder is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input backorder is not a valid integer.");
			return false;
		}
	}
	
	/**
	 * Function for Backorder Volume for Noir Input Checking
	 * @param input User's input
	 * @return boolean value of user's input for Backorder Volume for Noir being valid
	 */
	public static boolean Noir_backOrder_checking(String input) { // for function C
		try {
			int int_num = Integer.parseInt(input);
			if(int_num < 0) {
				System.out.println("Input backorder is not a valid positive integer.");
				return false;
			}
			else {
				return true;
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input backorder is not a valid integer.");
			return false;
		}
	}
	
}
