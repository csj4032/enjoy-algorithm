package elevenStreet.test01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2Test {

	@Test
	void solution() {
		Solution2 solution2 = new Solution2();
		Assertions.assertEquals(6, solution2.solution(new int[]{1, 3, -3}));
		Assertions.assertEquals(14, solution2.solution(new int[]{-8, 4, -0, 5, -3, 6}));
		Assertions.assertEquals(21, solution2.solution(new int[]{6, 10}));
		Assertions.assertEquals(26, solution2.solution(new int[]{0, 0, 0, 0, 0, 6, 10}));
		Assertions.assertEquals(3, solution2.solution(new int[]{6, 10}));
	}
}