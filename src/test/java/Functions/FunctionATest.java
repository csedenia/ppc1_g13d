package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

import org.junit.After;

import java.util.function.Function;

import java.io.PrintStream;

import java.io.ByteArrayOutputStream;

public class FunctionATest {
//	private final PrintStream standardOut = System.out;
//	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
//	@Before
//	public void setUp() {
//	    System.setOut(new PrintStream(outputStreamCaptor));
//	}
	
	@Test 
	public void A01_findCapacity() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.findCapacity(120000, 50000);
		assertEquals(aTest.getCapacityRose(), 2307);
		assertEquals(aTest.getCapacityNoir(), 9038);
	}

	@Test 
	public void A02_findCapacity() {
		FunctionA aTest = new FunctionA(3,1123000,550000,28.5f,31.4f,1300);
		aTest.findCapacity(1123000, 550000);
		assertEquals(aTest.getCapacityRose(), 40538);
		assertEquals(aTest.getCapacityNoir(), 76692);
	}
	
	@Test
	public void A01_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 2307);
		assertEquals(aTest.getOptimalNoir(), 9038);
	}

	@Test 
	public void A02_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(3,1123000,550000,28.5f,31.4f,1300);
		aTest.calculateGrossProfit();
		System.out.println(aTest.getOptimalRose());
		System.out.println(aTest.getOptimalNoir());
		assertEquals(aTest.getOptimalRose(), 40538);
		assertEquals(aTest.getOptimalNoir(), 76692);
	}
//	
//	@Test 
//	public void A01_checkAbnormalSituationB() {
//		FunctionA aTest = new FunctionA(1,50000,50000,12.5f,23.5f,112800);
//		aTest.calculateGrossProfit();
//		aTest.checkAbnormalSituation();
//		String expectedOutput = "w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!";
//		String output = outputStreamCaptor.toString().trim();
//		assertEquals(expectedOutput, output);
//	}
	
//	@After
//	public void tearDown() {
//	    System.setOut(standardOut);
//	}
}
