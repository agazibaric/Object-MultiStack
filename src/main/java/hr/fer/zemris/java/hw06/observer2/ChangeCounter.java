package hr.fer.zemris.java.hw06.observer2;

/**
 * Class represents implementation of {@link IntegerStorageObserver}
 * that counts how many times state has changed.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class ChangeCounter implements IntegerStorageObserver {

	private int numberOfValueChanges;
	
	@Override
	public void valueChanged(IntegerStorageChange istorageChange) {
		System.out.format("Number of value changes since tracking: %d%n", ++numberOfValueChanges);
	}

}
