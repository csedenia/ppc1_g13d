package Functions;

import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionB_Test {
	
	@Test
	public void test1() { //boundary testing 1 for update()
		FunctionB tester = new FunctionB(2308, 400, 300, 0f, 14.9f); // Initialize the input data, assume they are all correct
		tester.update();
		assertEquals(491, tester.getOpt_Revenue());
	}
	@Test
	public void test2() { //boundary testing 2 for update()
		FunctionB tester = new FunctionB(2308, 400, 300, 15.9f, 0f); // Initialize the input data, assume they are all correct
		tester.update();
		assertEquals(795, tester.getOpt_Revenue());
	}
	@Test
	public void test3() { //typical values testing 1 for update()
		FunctionB tester = new FunctionB(2308, 100, 100, 1f, 2f); // Initialize the input data, assume they are all correct
		tester.update();
		assertEquals(19, tester.getOpt_Revenue());
	}
	@Test
	public void test4() { //typical values testing 1 for update()
		FunctionB tester = new FunctionB(2308, 200, 200, 3f, 5f); // Initialize the input data, assume they are all correct
		tester.update();
		assertEquals(110, tester.getOpt_Revenue());
	}
	
	

}
