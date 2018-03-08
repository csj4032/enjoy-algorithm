package recursion;

public class Power {

	public int power(int k, int n) {
		if (n == 0) return k;
		return k * power(k, n - 1);
	}
}
