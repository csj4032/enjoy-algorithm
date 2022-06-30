package medium.p3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

	@Test
	void test() {
		Solution solution = new Solution();
		Assertions.assertEquals(0, solution.lengthOfLongestSubstring(""));
		Assertions.assertEquals(2, solution.lengthOfLongestSubstring("aab"));
		Assertions.assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"));
		Assertions.assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"));
	}
}