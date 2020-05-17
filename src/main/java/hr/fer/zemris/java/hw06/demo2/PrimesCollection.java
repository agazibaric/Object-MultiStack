package hr.fer.zemris.java.hw06.demo2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class that represents collection of prime numbers.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class PrimesCollection implements Iterable<Integer> {

	/** number of primes you want to get from collection */
	private int numberOfPrimes;
	
	/**
	 * Constructor that creates new {@code PrimesCollection} object.
	 * 
	 * @param numberOfPrimes number of primes that will collection offer 
	 */
	public PrimesCollection(int numberOfPrimes) {
		this.numberOfPrimes = numberOfPrimes;
	}
	
	/**
	 * Method used for calculating prime number at given index.
	 * 
	 * @param indexOfPrime index of prime number
	 * @return             prime number at given index
	 */
	private int getPrime(int indexOfPrime) {
		if (indexOfPrime <= 0)
			throw new IllegalArgumentException("Index must be grater then zero");
		
		if (indexOfPrime == 1)
			return 2;
		
		int number = 1;
		while (indexOfPrime > 1) {
			number += 2;
			if (isPrime(number)) {
				indexOfPrime--;
			}
		}
		return number;
	}
	
	/**
	 * Method used for checking if a given number is prime number.
	 * 
	 * @param number number that is checked
	 * @return       {@code true} if given number is a prime number,
	 *       		 {@code false} otherwise
	 */
	private boolean isPrime(int number) {
		if (number <= 1)
			throw new IllegalArgumentException("Given number is invalid. You entered: " + number);
		
		if (number % 2 == 0)
			return false;
		
		int limit = (int)Math.sqrt(number) + 1;
		for (int i = 3; i < limit; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new IteratorImpl();
	}
	
	/**
	 * Private implementation of {@link Iterator}.
	 * 
	 * @author Ante Gazibarić
	 * @version 1.0
	 *
	 */
	private class IteratorImpl implements Iterator<Integer> {

		/** current number of primes */
		private int currentNumberOfPrime = 1;
		
		@Override
		public boolean hasNext() {
			return currentNumberOfPrime <= numberOfPrimes;
		}

		@Override
		public Integer next() {
			if(!hasNext())
				throw new NoSuchElementException("There is no more elements");
			
			return getPrime(currentNumberOfPrime++);
		}
		
	}
	
	
	
}
