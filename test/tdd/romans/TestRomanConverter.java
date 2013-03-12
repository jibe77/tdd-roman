package tdd.romans;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRomanConverter {

	@Test
	public void testSimpleValues() {
		assertEquals("I", Converter.toRoman(1));
		assertEquals("V", Converter.toRoman(5));
		assertEquals("X", Converter.toRoman(10));
		assertEquals("L", Converter.toRoman(50));
		assertEquals("C", Converter.toRoman(100));
		assertEquals("D", Converter.toRoman(500));
		assertEquals("M", Converter.toRoman(1000));
	}
	
	@Test
	public void testI() {
		assertEquals("I", Converter.toRoman(1));
		assertEquals("II", Converter.toRoman(2));
		assertEquals("III", Converter.toRoman(3));
		assertEquals("IV", Converter.toRoman(4));
		assertEquals("V", Converter.toRoman(5));
		assertEquals("VI", Converter.toRoman(6));
		assertEquals("VII", Converter.toRoman(7));
		assertEquals("VIII", Converter.toRoman(8));
		assertEquals("IX", Converter.toRoman(9));
		
	}
	
	@Test
	public void testNotAvailableValues() {
		try {
			Converter.toRoman(0);
			fail();
		} catch (NotAvailableValue naValue) {
			assertNotNull(naValue);
		}
		
		try {
			Converter.toRoman(3001);
			fail();
		} catch (NotAvailableValue naValue) {
			assertNotNull(naValue);
		}
	}
	
	@Test
	public void testSplit() {
		assertArrayEquals(new int[] {0, 0, 0, 1}, Converter.split(1));
		assertArrayEquals(new int[] {0, 0, 5, 1}, Converter.split(51));
		assertArrayEquals(new int[] {2, 8, 5, 1}, Converter.split(2851));
	}
}
