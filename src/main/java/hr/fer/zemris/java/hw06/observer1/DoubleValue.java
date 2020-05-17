package hr.fer.zemris.java.hw06.observer1;

/**
 * Class represents implementation of {@link IntegerStorageObserver}
 * that calculates two times value that is given first n times.
 * 
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class DoubleValue implements IntegerStorageObserver {

	/** number how many times it calculates double value
	 *  until it removes itself from the list of observers
	 */
	private int n;
	/** number that counts how many times value has changed */
	private int counter;
	
	/**
	 * Constructor that creates new {@code DoubleValue} object.
	 * 
	 * @param n number of times that double value will be calculated
	 */
	public DoubleValue(int n) {
		this.n = n;
	}
	
	@Override
	public void valueChanged(IntegerStorage istorage) {
		if (counter < n) {
			System.out.format("Double value: %d%n", istorage.getValue() * 2);
			counter++;
		} else {
			istorage.removeObserver(this);	
		}
		
	}

}
