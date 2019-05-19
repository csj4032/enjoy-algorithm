package elevenStreet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1Test {

	@Test
	void solution() {
		Solution1 solution1 = new Solution1();
		Assertions.assertEquals(0, solution1.solution(new int[]{1}));
	}
}