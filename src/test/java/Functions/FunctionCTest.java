package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionCTest {

	//Test Cases from Sample Test Cases
	@Test
	public void C01() {
		FunctionC c = new FunctionC(2301, 12000, 5000, 12.5f, 23.5f, 380, 180);
		c.update_backorder();
		
		assertEquals(20730, c.getOpt_Revenue()); //calculated using ms excel solver
	}
	
	@Test
	public void C02() {
		FunctionC c = new FunctionC(2301, 72000, 45000, 12.5f, 23.5f, 3500, 2800);
		c.update();
		
		assertEquals(154116, c.getOpt_Revenue()); //calculated using ms excel solver
	}

	//custom test case for FunctionC.reserve_backorder()
	@Test
	public void reserve_backorder_typical0() {
		FunctionC c = new FunctionC(2301, 9999, 9999, 12.5f, 23.5f, 100, 100);
		c.reserve_backorder();
		
		assertEquals(100, c.getOpt_Rose());
		assertEquals(100, c.getOpt_Noir());
		assertEquals(3600, c.getOpt_Revenue());
		assertEquals(true, c.getBko_fulfill());
	}
	
	@Test
	public void reserve_backorder_typical1() {
		FunctionC c = new FunctionC(2301, 1700, 999, 12.5f, 23.5f, 100, 100);
		c.reserve_backorder();
		
		assertEquals(99, c.getOpt_Rose());
		assertEquals(100, c.getOpt_Noir());
		assertEquals(3587, c.getOpt_Revenue());
		assertEquals(false, c.getBko_fulfill());
	}
	
	@Test
	public void reserve_backorder_typical2() {
		FunctionC c = new FunctionC(2301, 1699, 1000, 12.5f, 23.5f, 100, 100);
		c.reserve_backorder();
		
		assertEquals(99, c.getOpt_Rose());
		assertEquals(100, c.getOpt_Noir());
		assertEquals(3587, c.getOpt_Revenue());
		assertEquals(false, c.getBko_fulfill());
	}
	
	@Test
	public void reserve_backorder_typical3() {
		FunctionC c = new FunctionC(2301, 1699, 999, 12.5f, 23.5f, 100, 100);
		c.reserve_backorder();
		
		assertEquals(99, c.getOpt_Rose());
		assertEquals(100, c.getOpt_Noir());
		assertEquals(3587, c.getOpt_Revenue());
		assertEquals(false, c.getBko_fulfill());
	}
	
	@Test
	public void bko_valid_false() {
		FunctionC c = new FunctionC(2301, 1700, 1000, 12.5f, 23.5f, 0, 0);
		c.update_backorder();
		
		assertEquals(false, c.bko_ratio_valid());
	}
	
	@Test
	public void bko_valid_true() {
		FunctionC c = new FunctionC(2301, 1700, 1000, 12.5f, 23.5f, 100, 100);
		c.update_backorder();
		
		assertEquals(true, c.bko_ratio_valid());
	}
	
	@Test
	public void bko_valid_boundary0() {
		FunctionC c = new FunctionC(2301, 1200, 400, 12.5f, 23.5f, 0, 70);
		c.update_backorder();
		
		assertEquals(true, c.bko_ratio_valid());
	}
	
	public void bko_valid_boundary1() {
		FunctionC c = new FunctionC(2301, 1200, 400, 12.5f, 23.5f, 0, 69);
		c.update_backorder();
		
		assertEquals(false, c.bko_ratio_valid());
	}
}
