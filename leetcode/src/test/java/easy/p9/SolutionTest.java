package easy.p9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

	@Test
	void isPalindrome() {
		Solution solution = new Solution();
		Assertions.assertEquals(true, solution.isPalindrome(121));
		Assertions.assertEquals(false, solution.isPalindrome(-121));
		Assertions.assertEquals(false, solution.isPalindrome(10));
	}
}