package hr.fer.zemris.java.custom.scripting.exec;

import org.junit.Test;
import org.junit.Assert;

public class ValueWrapperTest {
	
	public static final Double THRESHOLD = 1E-4;
	
	@Test
	public void testForNull1() {
		ValueWrapper v1 = new ValueWrapper(null);
		Assert.assertNull(v1.getValue());
	}
	
	@Test
	public void testForNull2() {
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(null);
		v1.add(v2.getValue());
		
		Integer expected = 0;
		Integer actual = (Integer) v1.getValue();
		
		Assert.assertEquals(expected, actual);
		Assert.assertNull(v2.getValue());
	}
	
	@Test
	public void testForAddingIntegers() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(6));
		v1.add(v2.getValue());
		
		Integer expected1 = 11;
		Integer actual1 = (Integer) v1.getValue();
		Integer expected2 = 6;
		Integer actual2 = (Integer) v2.getValue();
		
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
	}
	
	@Test
	public void testForAddingIntegerDouble() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(3.3));
		v1.add(v2.getValue());
		
		Double expected1 = 8.3;
		Double actual1 = (Double) v1.getValue();
		Double expected2 = 3.3;
		Double actual2 = (Double) v2.getValue();
		
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
	}
	
	@Test
	public void testForAddingDouble() {
		ValueWrapper v1 = new ValueWrapper("5");
		ValueWrapper v2 = new ValueWrapper("6.2");
		v1.add(v2.getValue());
		
		Double expected = 11.2;
		Double actual = (Double) v1.getValue();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = RuntimeException.class)
	public void testForInvalidStringValue() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf("Ankica"));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(6.2));
		v1.add(v2.getValue());
		
	}
	
	@Test
	public void testForSubtractingIntegers() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(5));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(6));
		v1.substract(v2.getValue());
		
		Integer expected = -1;
		Integer actual = (Integer) v1.getValue();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testForDividingIntegers() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(10));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(3));
		v1.divide(v2.getValue());
		
		Integer expected = 3;
		Integer actual = (Integer) v1.getValue();
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testForDividingIntegerByZero() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(10));
		ValueWrapper v2 = new ValueWrapper(Integer.valueOf(0));
		v1.divide(v2.getValue());
	}
	
	@Test
	public void testForDividingDoubleByZero() {
		ValueWrapper v1 = new ValueWrapper(Integer.valueOf(10));
		ValueWrapper v2 = new ValueWrapper(Double.valueOf(0));
		v1.divide(v2.getValue());
		
		Double expected = Double.POSITIVE_INFINITY;
		Double actual = (Double) v1.getValue();
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testForMultiplyingDoubles() {
		ValueWrapper v1 = new ValueWrapper("2.2");
		ValueWrapper v2 = new ValueWrapper("2");
		v1.divide(v2.getValue());
		
		Double expected = Double.valueOf(1.1);
		Double actual = (Double) v1.getValue();
		Assert.assertEquals(expected, actual, THRESHOLD);
	}
	
	@Test
	public void testForComparingIntegers() {
		ValueWrapper v1 = new ValueWrapper(2);
		ValueWrapper v2 = new ValueWrapper(3);
		
		int actual = v1.numComare(v2.getValue());
		boolean isLessThenZero = actual < 0;
		Assert.assertTrue(isLessThenZero);
	}
	
	@Test
	public void testForComparingIntegerAndDouble() {
		ValueWrapper v1 = new ValueWrapper(2);
		ValueWrapper v2 = new ValueWrapper("-1E2");
		
		int actual = v1.numComare(v2.getValue());
		boolean isGreaterThenZero = actual > 0;
		Assert.assertTrue(isGreaterThenZero);
	}
	
	@Test
	public void testForComparingSameIntegers() {
		ValueWrapper v1 = new ValueWrapper(2);
		ValueWrapper v2 = new ValueWrapper("2");
		
		int actual = v1.numComare(v2.getValue());
		boolean isGreaterThenZero = actual == 0;
		Assert.assertTrue(isGreaterThenZero);
	}
	
	@Test
	public void testForComparingDoubles() {
		ValueWrapper v1 = new ValueWrapper(Double.valueOf(100));
		ValueWrapper v2 = new ValueWrapper("-1E2");
		
		int actual = v1.numComare(v2.getValue());
		boolean isGreaterThenZero = actual > 0;
		Assert.assertTrue(isGreaterThenZero);
	}
	

}
