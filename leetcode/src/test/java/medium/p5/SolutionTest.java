package medium.p5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void isPalindrome() {
		Solution solution = new Solution();
		// Assertions.assertEquals("bab", solution.longestPalindrome("babad"));
		Assertions.assertEquals("bb", solution.longestPalindrome("cbbd"));
	}
}