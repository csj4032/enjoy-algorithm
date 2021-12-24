package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeastCommonMultipleTest {

	public int solution(int[] arr) {
		LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple();
		int answer = leastCommonMultiple.nlcm(arr);
		return answer;
	}

	@Test
	public void test() {
		Assertions.assertEquals(168, solution(new int[]{2, 6, 8, 14}));
		Assertions.assertEquals(6, solution(new int[]{1, 2, 3}));
	}

	@Test
	public void gcdTest() {
		LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple();
		Assertions.assertEquals(4, leastCommonMultiple.gcd(12, 16));
		Assertions.assertEquals(1, leastCommonMultiple.gcd(2, 5));
	}

	@Test
	public void lcmTest() {
		LeastCommonMultiple leastCommonMultiple = new LeastCommonMultiple();
		Assertions.assertEquals(168, leastCommonMultiple.lcm(24, 14));
	}
}