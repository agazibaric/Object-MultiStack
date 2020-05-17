package hr.fer.zemris.java.custom.scripting.exec;

import org.junit.Test;
import org.junit.Assert;

public class ObjectMultistackTest {
	
	private static final Double THRESHOLD = 1E-4; 
	
	@Test
	public void testForTwoKeys() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		ValueWrapper year = new ValueWrapper(Integer.valueOf(2000));
		multistack.push("year", year);
		
		ValueWrapper price = new ValueWrapper(200.51);
		multistack.push("price", price);
		
		Integer expected1 = 2000;
		Integer actual1 = (Integer) multistack.peek("year").getValue();
		Double expected2 = 200.51;
		Double actual2 = (Double) multistack.peek("price").getValue();
		
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2, THRESHOLD);
	}
	
	@Test
	public void testForEmptyStack() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		ValueWrapper year = new ValueWrapper(Integer.valueOf(2000));
		multistack.push("year", year);
		multistack.peek("year");
		boolean isEmpty1 = multistack.isEmpty("year");
		multistack.pop("year");
		boolean isEmpty2 = multistack.isEmpty("year");
		
		Assert.assertTrue(isEmpty1);
		Assert.assertFalse(isEmpty2);
	}
	
	@Test
	public void testForPushed2Values() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		ValueWrapper year1 = new ValueWrapper(Integer.valueOf(2000));
		ValueWrapper year2 = new ValueWrapper(Integer.valueOf(2018));
		multistack.push("year", year1);
		multistack.push("year", year2);
		Integer actual = (Integer) multistack.pop("year").getValue();
		Integer expected = 2018;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test (expected = ObjectMultistackException.class)
	public void testForPopingFromEmptyStack() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		ValueWrapper year1 = new ValueWrapper(Integer.valueOf(2000));
		multistack.push("year", year1);
		multistack.pop("year");
		multistack.pop("year");
	}
	
	@Test (expected = NullPointerException.class)
	public void testKeyNull() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		ValueWrapper year = new ValueWrapper(Integer.valueOf(2000));
		multistack.push(null, year);
	}
	
	@Test (expected = NullPointerException.class)
	public void testValueNull() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		multistack.push("year", null);
	}
	
	@Test (expected = ObjectMultistackException.class)
	public void testForPeekFromEmptyStack() {
		ObjectMultistack multistack = new ObjectMultistack();
		
		ValueWrapper year1 = new ValueWrapper(Integer.valueOf(2000));
		multistack.push("year", year1);
		multistack.pop("year");
		multistack.peek("year");
	}

}
