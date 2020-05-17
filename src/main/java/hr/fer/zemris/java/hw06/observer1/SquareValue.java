package hr.fer.zemris.java.hw06.observer1;

/**
 * Class represents implementation of {@link IntegerStorageObserver}
 * that calculates square of given value.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class SquareValue implements IntegerStorageObserver {

	@Override
	public void valueChanged(IntegerStorage istorage) {
		int value = istorage.getValue();
		System.out.format("Proided new value: %d, square is %d%n", value, value * value);
	}

}
