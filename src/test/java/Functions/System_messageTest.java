package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class System_messageTest {

	@Test
	public void W02_SystemMessage() {
		FunctionA aTest = new FunctionA(1,1000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		System_message output = new System_message(aTest.getOptimalRose(), aTest.getOptimalNoir(), 1, 120000, 1000);
		System.out.println(output);
		assertEquals(output, 2);
	}

	@Test
	public void W00_SystemMessage() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		System_message output = new System_message(aTest.getOptimalRose(), aTest.getOptimalNoir(), 1, 120000, 1000);
		assertEquals(output, 0);
	}
}
