package recursion;

public class Recursion02 {

	public void recursion(int k) {
		// Base Case
		if (k <= 0) {
			return;
		}
		System.out.println("Hello...");
		// Recursion Case
		recursion(k - 1);
	}
}
