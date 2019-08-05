package elevenStreet.test02;

import elevenStreet.test02.Solution1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1Test {

	@Test
	void solution() {
		Solution1 solution1 = new Solution1();
		Assertions.assertEquals(2, solution1.solution(53, 1953786));
		Assertions.assertEquals(2, 7, solution1.solution(78, 195378678));
	}
}