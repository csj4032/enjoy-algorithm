package medium.p5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
<<<<<<< Updated upstream
	void isPalindrome() {
		Solution solution = new Solution();
		// Assertions.assertEquals("bab", solution.longestPalindrome("babad"));
		Assertions.assertEquals("bb", solution.longestPalindrome("cbbd"));
=======
	void test() {
		Solution solution = new Solution();
		Assertions.assertEquals("bab", solution.longestPalindrome("babad"));
		Assertions.assertEquals("bb", solution.longestPalindrome("cbbd"));
		Assertions.assertEquals("a", solution.longestPalindrome("a"));
		Assertions.assertEquals("a", solution.longestPalindrome("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg"));
>>>>>>> Stashed changes
	}
}