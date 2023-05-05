package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class System_messageTest {

	@Test
	public void S01_checkW1_2() {
		FunctionA aTest = new FunctionA(1,1000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		System_message output = new System_message(aTest.getOptimalRose(), aTest.getOptimalNoir(), 1, 50000, 1000);
		assertEquals(output.checkW1(), false);
		assertEquals(output.checkW2(), true);
	}

	@Test
	public void S02_checkW1_2() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		System_message output = new System_message(aTest.getOptimalRose(), aTest.getOptimalNoir(), 1, 50000, 120000);
		assertEquals(output.checkW1(), false);
		assertEquals(output.checkW2(), false);
	}
}
