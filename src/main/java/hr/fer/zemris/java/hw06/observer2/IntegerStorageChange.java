package hr.fer.zemris.java.hw06.observer2;

/**
 * Class that contains information about state when value is changed.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class IntegerStorageChange {

	private IntegerStorage integerStorage;
	private int oldValue;
	private int newValue;
	
	/**
	 * Constructor that creates new {@code IntegerStorageChange} object.
	 * 
	 * @param integerStorage integer storage that measures value changes
	 * @param oldValue old value
	 * @param newValue new value
	 */
	public IntegerStorageChange(IntegerStorage integerStorage, int oldValue, int newValue) {
		this.integerStorage = integerStorage;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	/**
	 * Method returns integer storage object that messures value changes.
	 * 
	 * @return integer storage
	 */
	public IntegerStorage getIntegerStorage() {
		return integerStorage;
	}
	
	/**
	 * Method returns value before change
	 * 
	 * @return old value
	 */
	public int getOldValue() {
		return oldValue;
	}
	
	/**
	 * Method returns value after change
	 * 
	 * @return new value
	 */
	public int getNewValue() {
		return newValue;
	}
	
}
