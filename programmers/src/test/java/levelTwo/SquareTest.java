package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

	public long solution(long w, long h) {
		long area = w * h;
		return area - (w + h - gcd(w, h));
	}

	public long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	@Test
	public void test() {
		assertEquals(0, solution(10, 1));
		assertEquals(6, solution(3, 3));
		assertEquals(8, solution(3, 5));
		assertEquals(90, solution(12, 9));
		assertEquals(80, solution(12, 8));
	}
}