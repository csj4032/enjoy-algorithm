package elevenStreet.test01;

import elevenStreet.test01.Solution1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1Test {

	@Test
	void solution() {
		Solution1 solution1 = new Solution1();
		Assertions.assertEquals(3, solution1.solution(2));
		Assertions.assertEquals(6, solution1.solution(3));
		Assertions.assertEquals(10, solution1.solution(4));
		Assertions.assertEquals(15, solution1.solution(5));
		Assertions.assertEquals(5, solution1.solution(6));
		Assertions.assertEquals(5, solution1.solution(15));
		Assertions.assertEquals(5, solution1.solution(17));
		Assertions.assertEquals(5, solution1.solution(18));
	}
}