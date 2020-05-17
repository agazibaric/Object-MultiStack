package hr.fer.zemris.java.custom.scripting.demo;

import hr.fer.zemris.java.custom.scripting.exec.ValueWrapper;

/**
 * Program that represents demo of {@link ValueWrapperk}.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class ValueWrapperDemo {

	
	public static void main(String[] args) {
		
		ValueWrapper v1 = new ValueWrapper(null);
		ValueWrapper v2 = new ValueWrapper(null);
		v1.add(v2.getValue()); // v1 now stores Integer(0); v2 still stores null.
		System.out.println("v1 value: " + v1.getValue());
		System.out.println("v1 class: " + v1.getValue().getClass().getSimpleName());
		System.out.println("v2 value: " + v2.getValue() + "\n");
		
		ValueWrapper v3 = new ValueWrapper("1.2E1");
		ValueWrapper v4 = new ValueWrapper(Integer.valueOf(1));
		v3.add(v4.getValue()); // v3 now stores Double(13); v4 still stores Integer(1).
		System.out.println("v3 value: " + v3.getValue());
		System.out.println("v3 class: " + v3.getValue().getClass().getSimpleName());
		System.out.println("v4 value: " + v4.getValue());
		System.out.println("v4 class: " + v4.getValue().getClass().getSimpleName() + "\n");
		
		ValueWrapper v5 = new ValueWrapper("12");
		ValueWrapper v6 = new ValueWrapper(Integer.valueOf(1));
		v5.add(v6.getValue()); // v5 now stores Integer(13); v6 still stores Integer(1).
		System.out.println("v5 value: " + v5.getValue());
		System.out.println("v5 class: " + v5.getValue().getClass().getSimpleName());
		System.out.println("v6 value: " + v6.getValue());
		System.out.println("v6 class: " + v6.getValue().getClass().getSimpleName() + "\n");
		
//		ValueWrapper v7 = new ValueWrapper("Ankica");
//		ValueWrapper v8 = new ValueWrapper(Integer.valueOf(1));
//		v7.add(v8.getValue()); //throws RuntimeException
		
	}
	
}
