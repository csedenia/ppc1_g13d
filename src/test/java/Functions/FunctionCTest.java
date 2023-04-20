package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionCTest {
	
	/*
	 * ===================================
	 * test cases for reserve_backorder()
	 * ===================================
	 */
	@Test
	public void reserve_backorder_typical() { //typical test for reserve_backorder()
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 380, 100);
		functionC.reserve_backorder();
		//required_labor = 380*5 + 100*12 = 3100, <120000
		//required_grape = 380*6 + 100*4 = 2680, <5000
		//Bko_fulfill == true
		
		assertEquals(functionC.getBko_fulfill(), true);
	}
	
	@Test
	public void reserve_backorder_boundary1() { //boundary test case 1 for reserve_backorder()
		FunctionC functionC = new FunctionC(2301, 1, 5000, 12.0f, 22.0f, 1, 0);
		functionC.reserve_backorder();
		//required_labor = 1*5 = 5, >1
		//required_grape = 1*6 = 6, <5000
		//Bko_fulfill == false
		
		assertEquals(functionC.getBko_fulfill(), false);
	}

	@Test
	public void reserve_backorder_boundary2() { //boundary test case 2 for reserve_backorder()
		FunctionC functionC = new FunctionC(2301, 120000, 1, 12.0f, 22.0f, 1, 0);
		functionC.reserve_backorder();
		//required_labor = 1*5 = 5, <120000
		//required_grape = 1*6 = 6, >1
		//Bko_fulfill == false
		
		assertEquals(functionC.getBko_fulfill(), false);
	}
	
	@Test
	public void reserve_backorder_boundary3() { //boundary test case 3 for reserve_backorder()
		FunctionC functionC = new FunctionC(2301, 1, 1, 12.0f, 22.0f, 1, 0);
		functionC.reserve_backorder();
		//required_labor = 1*5 = 5, >1
		//required_grape = 1*6 = 6, >1
		//Bko_fulfill == false
		
		assertEquals(functionC.getBko_fulfill(), false);
	}
	
	@Test
	public void reserve_backorder_boundary4() { //boundary test case 4 for reserve_backorder()
		FunctionC functionC = new FunctionC(2301, 17, 10, 12.0f, 22.0f, 1, 1);
		functionC.reserve_backorder();
		//required_labor = 1*5 + 1*12 = 17, =17
		//required_grape = 1*6 + 1*4 = 10, =10
		//Bko_fulfill == true
		
		assertEquals(functionC.getBko_fulfill(), true);
	}
	
	/* 
	 * ===================================
	 * test cases for update_backorder()
	 * ===================================
	 * remark: update() is tested in FunctionB_test.java
	 */
	@Test
	public void update_backorder_typical1() {
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 380, 100);
		functionC.update_backorder();
		
		assertEquals(functionC.getOpt_Rose(), 380);
		assertEquals(functionC.getOpt_Noir(), 680);
		assertEquals(functionC.getOpt_Revenue(), 19520);
	}
	
	@Test
	public void update_backorder_typical2() {
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 120000, 120000);
		functionC.update_backorder();
		
		assertEquals(functionC.getOpt_Rose(), 0);
		assertEquals(functionC.getOpt_Noir(), 1250);
		assertEquals(functionC.getOpt_Revenue(), 27500);
	}
	
	/* 
	 * ===================================
	 * test cases for bko_ratio_valid()
	 * ===================================
	 */
	@Test
	public void bko_ratio_valid_typical1() {
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 380, 100);
		functionC.update_backorder();
		
		assertEquals(functionC.getOpt_Rose(), 380);
		assertEquals(functionC.getOpt_Noir(), 680);
		assertEquals(functionC.getOpt_Revenue(), 19520);
		
		//bko_ratio = (380+100)/(380+680) =0.452, <0.7
		assertEquals(functionC.bko_ratio_valid(), false);
	}
	
	@Test
	public void bko_ratio_valid_typical2() {
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 380, 380);
		functionC.update_backorder();
		
		assertEquals(functionC.getOpt_Rose(), 380);
		assertEquals(functionC.getOpt_Noir(), 680);
		assertEquals(functionC.getOpt_Revenue(), 19520);
		
		//bko_ratio = (380+380)/(380+680) =0.717, >0.7
		assertEquals(functionC.bko_ratio_valid(), true);
	}
	
	@Test
	public void bko_ratio_valid_boundary1() {
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 380, 362);
		functionC.update_backorder();
		
		assertEquals(functionC.getOpt_Rose(), 380);
		assertEquals(functionC.getOpt_Noir(), 680);
		assertEquals(functionC.getOpt_Revenue(), 19520);
		
		//bko_ratio = (380+362)/(380+680) =0.7, =0.7
		assertEquals(functionC.bko_ratio_valid(), true);
	}
	
	@Test
	public void bko_ratio_valid_boundary2() {
		FunctionC functionC = new FunctionC(2301, 120000, 5000, 12.0f, 22.0f, 380, 361);
		functionC.update_backorder();
		
		assertEquals(functionC.getOpt_Rose(), 380);
		assertEquals(functionC.getOpt_Noir(), 680);
		assertEquals(functionC.getOpt_Revenue(), 19520);
		
		//bko_ratio = (380+361)/(380+680) =0.699, <0.7
		assertEquals(functionC.bko_ratio_valid(), false);
	}
}
