package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class System_messageTest {

	@Test
	public void S01_checkW1_2() {
		FunctionA aTest = new FunctionA(3,1123000,550000,28.5f,31.4f,1300);
		aTest.calculateGrossProfit();
		System_message output = new System_message(aTest.getOptimalRose(), aTest.getOptimalNoir(), 3, 550000, 1123000);
		assertEquals(output.checkW1(), true); 
		assertEquals(output.checkW2(), true); 
	}

	@Test
	public void S02_checkW1_2() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		System_message output = new System_message(aTest.getOptimalRose(), aTest.getOptimalNoir(), 1, 50000, 120000);
		assertEquals(output.checkW1(), true);
		assertEquals(output.checkW2(), true);
	}
	
	@Test
	public void S03_checkW3() {
		FunctionC cTest = new FunctionC(2301, 1000, 1000, 12.5f, 23.5f, 1, 1);
		cTest.update_backorder();
		System_message output = new System_message(cTest.getOpt_Rose(), cTest.getOpt_Noir(), 1, 1000, 1000);
		assertEquals(output.checkW1(), false);
		assertEquals(output.checkW2(), false);
		assertEquals(output.checkW3(cTest), true);
	}
}
