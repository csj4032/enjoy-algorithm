package levelTwo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

	public int solution(int n) {
		int[] ints = new int[n+1];
		ints[0] = 0;
		ints[1] = 1;
		ints[2] = 1;
		if (n == 2) return ints[2];
		for (int i = 3; i <= n; i++) {
			ints[i] = ints[i - 2] + ints[i - 1];
		}
		return ints[n];
	}

	@Test
	public void test() {
		assertEquals(2, solution(3));
		assertEquals(5, solution(5));
	}
}