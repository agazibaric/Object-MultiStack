package hr.fer.zemris.java.hw06.demo2;

/**
 * Program shows use of {@link PrimesCollection}.
 * 
 * @author Ante Gazibarić
 * @version 1.0
 *
 */
public class PrimesDemo1 {
	
	public static void main(String[] args) {
		
		PrimesCollection primesCollection = new PrimesCollection(20);
		for (Integer prime : primesCollection) {
			System.out.println("Got prime: " + prime);
		}
		
	}

}
