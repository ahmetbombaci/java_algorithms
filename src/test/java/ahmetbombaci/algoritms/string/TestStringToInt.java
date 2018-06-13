package ahmetbombaci.algoritms.string;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestStringToInt {

	StringToInt s = new StringToInt();

	@Test
	public void emptyString() {
		assertEquals(0, s.myAtoi(""));
	}

	@Test
	public void singleDigit() {
		assertEquals(7, s.myAtoi("7"));
	}
	
	@Test
	public void ignoreSpaces() {
		assertEquals(123, s.myAtoi("   123"));
	}

	@Test
	public void ignoreSpacesNegative() {
		assertEquals(-123, s.myAtoi("     -123"));
	}

	@Test
	public void spaceBetweenSignOperatorAndDigit() {
		assertEquals(0, s.myAtoi("    + 123"));
	}

	@Test
	public void maxInt() {
		assertEquals(Integer.MAX_VALUE, s.myAtoi("     +" + Integer.MAX_VALUE));
	}
	
	@Test
	public void minInt() {
		assertEquals(Integer.MIN_VALUE, s.myAtoi("     " + Integer.MIN_VALUE));
	}
	
	@Test
	public void lessthanMinInt() {
		assertEquals(Integer.MIN_VALUE, s.myAtoi("  -6147483648  "));
	}
}
