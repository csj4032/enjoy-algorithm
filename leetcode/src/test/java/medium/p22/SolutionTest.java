package medium.p22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		Solution solution = new Solution();
		Assertions.assertEquals(null, solution.generateParenthesis(3));
	}
}