package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class Input_checkingTest {

	@Test
	public void test1() { // for date checking
		assertEquals(false, Input_checking.date_checking("second of June"));
	}
	@Test
	public void test2() { // for date checking
		assertEquals(true, Input_checking.date_checking("2308"));
	}
	@Test
	public void test3() { // for date checking
		assertEquals(false, Input_checking.date_checking("2316"));
	}
	@Test
	public void test4() { // for labor_capacity_checking
		assertEquals(false, Input_checking.labor_capacity_checking("one thousand"));
	}
	@Test
	public void test5() { // for labor_capacity_checking
		assertEquals(true, Input_checking.labor_capacity_checking("1000"));
	}
	@Test
	public void test6() { // for grape_capacity_checking
		assertEquals(true, Input_checking.grape_capacity_checking("1000"));
	}
	@Test
	public void test7() { // for grape_capacity_checking
		assertEquals(false, Input_checking.grape_capacity_checking("two thousand"));
	}
	@Test
	public void test8() { // for pr_checking
		assertEquals(false, Input_checking.pr_checking("twenty point five"));
	}
	@Test
	public void test9() { // for pr_checking
		assertEquals(true, Input_checking.pr_checking("23.8"));
	}
	@Test
	public void test10() { // for pn_checking
		assertEquals(true, Input_checking.pn_checking("29.44"));
	}
	@Test
	public void test11() { // for pn_checking
		assertEquals(false, Input_checking.pn_checking("five point six"));
	}
	@Test
	public void test12() { // for numweek_checking
		assertEquals(false, Input_checking.numweek_checking("five"));
	}
	@Test
	public void test13() { // for numweek_checking
		assertEquals(true, Input_checking.numweek_checking("8"));
	}
	@Test
	public void test14() { // for numweek_checking
		assertEquals(false, Input_checking.numweek_checking("16"));
	}
	@Test
	public void test15() { // for fixedCost_checking
		assertEquals(true, Input_checking.fixedCost_checking("9999"));
	}
	@Test
	public void test16() { // for fixedCost_checking
		assertEquals(false, Input_checking.fixedCost_checking("nine"));
	}
	@Test
	public void test17() { // for Rose_backOrder_checking
		assertEquals(false, Input_checking.Rose_backOrder_checking("five"));
	}
	@Test
	public void test18() { // for Rose_backOrder_checking
		assertEquals(true, Input_checking.Rose_backOrder_checking("5000"));
	}
	@Test
	public void test19() { // for Noir_backOrder_checking
		assertEquals(true, Input_checking.Noir_backOrder_checking("5000"));
	}
	@Test
	public void test20() { // for Noir_backOrder_checking
		assertEquals(false, Input_checking.Noir_backOrder_checking("I want three hundred"));
	}
	

}
