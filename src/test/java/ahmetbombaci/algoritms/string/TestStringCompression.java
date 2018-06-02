package ahmetbombaci.algoritms.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringCompression {
	
	StringCompression compressor = new StringCompression();

	@Test
	public void testEmptyString() {
		assertEquals("", compressor.compress(""));
	}
	
	@Test
	public void testSingleChar() {
		assertEquals("a", compressor.compress("a"));
	}

	@Test
	public void testConsecutiveChars() {
		assertEquals("abcd", compressor.compress("abcd"));
	}
	
	@Test
	public void testQuestion() {
		assertEquals("a2b1c5a3", compressor.compress("aabcccccaaa"));
	}

}
