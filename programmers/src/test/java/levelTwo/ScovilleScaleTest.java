package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScovilleScaleTest {

	public int solution(int[] scoville, int K) {
		int answer = ScovilleScale.of(scoville).mix(K);
		return answer;
	}

	@Test
	public void test() {
		Assertions.assertEquals(2, solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
	}
}