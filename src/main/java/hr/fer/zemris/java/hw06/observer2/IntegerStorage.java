package hr.fer.zemris.java.hw06.observer2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents storage of integer numbers.
 * It can store observers that are called any time value of stored value is changed.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class IntegerStorage {

	/** value that is stored */
	private int value;
	/** observers that are called whenever value is changed */
	private List<IntegerStorageObserver> observers;

	/**
	 * Constructor that creates new {@code IntegerStorage} object.
	 * 
	 * @param initialValue value that is stored
	 */
	public IntegerStorage(int initialValue) {
		this.value = initialValue;
		observers = new ArrayList<>();
	}

	/**
	 * Method for adding observers.
	 * 
	 * @param observer that observe value changes
	 */
	public void addObserver(IntegerStorageObserver observer) {
		// add the observer in observers if not already there ...
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}

	/**
	 * Method that removes given observer form the list of observers.
	 * 
	 * @param observer observer that is removed
	 */
	public void removeObserver(IntegerStorageObserver observer) {
		// remove the observer from observers if present ...
		observers.remove(observer);
	}

	/**
	 * Method removes all observes from the list
	 */
	public void clearObservers() {
		// remove all observers from observers list ...
		observers.clear();
	}

	/**
	 * Method that returns value currently stored in storage.
	 * 
	 * @return value that is stored
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Method used for setting new value.
	 *  
	 * @param value new value that is stored
	 */
	public void setValue(int value) {
		// Only if new value is different than the current value:
		if (this.value != value) {
			// Update current value
			IntegerStorageChange istorageChange = new IntegerStorageChange(this, this.value, value);
			this.value = value;
			// Notify all registered observers
			if (observers != null) {
				// Iterate through observers list backwards
				// If object at current index gets removed it doesn't effect on iteration process
				for (int index = observers.size() - 1; index >= 0; index--) {
					observers.get(index).valueChanged(istorageChange);
				}
			}
		}
	}

}
