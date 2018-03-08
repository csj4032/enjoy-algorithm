package recursion;

public class Recursion03 {

	public int recursion(int n) {
		if (n <= 0) {
			return 0;
		}
		return n + recursion(n - 1);
	}
}