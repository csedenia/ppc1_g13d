package Functions;

import static org.junit.Assert.*;

import org.junit.Test;


public class FunctionB_Test {
	
	@Test
	public void test1() { //boundary testing 1 for update()
		FunctionB tester = new FunctionB(2308, 400, 300, 0f, 14.9f); // Initialize the input data, assume they are all correct
		tester.update();
		assertEquals(tester.getOpt_Revenue(), 491);
	}
	@Test
	public void test2() { //boundary testing 2 for update()
		FunctionB tester = new FunctionB(2308, 400, 300, 15.9f, 0f); // Initialize the input data, assume they are all correct
		assertEquals(tester.getOpt_Revenue(), 795);
	}

}
