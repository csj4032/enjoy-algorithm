package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromeTest {

	@Test
	public void test() {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		Assertions.assertEquals(7, longestPalindrome.solution("abcdcba"));
		Assertions.assertEquals(3, longestPalindrome.solution("abacde"));
	}
}