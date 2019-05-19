package elevenStreet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2Test {

	@Test
	void solution() {
		Solution2 solution2 = new Solution2();
		Assertions.assertEquals(0, solution2.solution(new int[]{1}));
	}
}