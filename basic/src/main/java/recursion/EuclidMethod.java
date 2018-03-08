package recursion;

public class EuclidMethod {

	public int gcd(int m, int n) {
		if (m < n) {
			int tmp = m;
			m = n;
			n = tmp;
		}

		if (m % n == 0) {
			return n;
		} else {
			return gcd(n, m % n);
		}
	}

	public int gcd2(int m, int n) {
		if (m % n == 0) {
			return n;
		} else {
			return gcd2(n, m % n);
		}
	}
}
