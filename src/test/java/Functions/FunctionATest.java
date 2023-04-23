package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

import org.junit.After;

import java.util.function.Function;

import java.io.PrintStream;

import java.io.ByteArrayOutputStream;

public class FunctionATest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	@Before
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}

	@Test
	public void A01_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 0);
		assertEquals(aTest.getOptimalNoir(), 5000);
	}

	@Test 
	public void A02_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(3,3000,4000,28.5f,31.4f,1300);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 15000);
		assertEquals(aTest.getOptimalNoir(), 0);
	}
	
	@Test 
	public void A03_checkAbnormalSituationB() {
		FunctionA aTest = new FunctionA(1,50000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		aTest.checkAbnormalSituation();
		String expectedOutput = "w2: Insufficient labor supplied to utilize the grape resource (less than 90%)!";
		String output = outputStreamCaptor.toString().trim();
		assertEquals(expectedOutput, output);
	}
	
	@After
	public void tearDown() {
	    System.setOut(standardOut);
	}
}
