package hr.fer.zemris.java.hw06.observer1;

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
	public void valueChanged(IntegerStorage istorage) {
		System.out.format("Number of value changes since tracking: %d%n", ++numberOfValueChanges);
	}

}
