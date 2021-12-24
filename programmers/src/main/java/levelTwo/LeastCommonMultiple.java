package levelTwo;

import java.util.Arrays;

public class LeastCommonMultiple {

	public int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	public int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	public int nlcm(int[] arr) {
		return Arrays.stream(arr).boxed().reduce((a, b) -> lcm(a, b)).get();
	}
}
