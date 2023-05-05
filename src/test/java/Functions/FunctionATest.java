package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;

import org.junit.After;

import java.util.function.Function;

import java.io.PrintStream;

import java.io.ByteArrayOutputStream;

public class FunctionATest {
	@Test
	public void A01_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(1,120000,50000,12.5f,23.5f,112800);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 0);
		assertEquals(aTest.getOptimalNoir(), 5000);
	}

	@Test 
	public void A02_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(3,1123000,550000,28.5f,31.4f,1300);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 15000);
		assertEquals(aTest.getOptimalNoir(), 0);
	}
	
	@Test
	public void A03_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(3,2000,2000,28.5f,31.4f,1300);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 308);
		assertEquals(aTest.getOptimalNoir(), 38);
	}

	@Test
	public void A04_calculateGrossProfit() {
		FunctionA aTest = new FunctionA(3,10000,20000,28.5f,31.4f,1300);
		aTest.calculateGrossProfit();
		assertEquals(aTest.getOptimalRose(), 2000);
		assertEquals(aTest.getOptimalNoir(), 0);
	}
}
