package hr.fer.zemris.java.hw06.observer1;

/**
 * Interface that represents general form of observer.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public interface IntegerStorageObserver {

	/**
	 * Method that is called whenever value in storage is changed.
	 * 
	 * @param istorage object that contains value
	 */
	void valueChanged(IntegerStorage istorage);
	
}
