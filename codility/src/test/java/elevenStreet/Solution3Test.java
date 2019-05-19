package elevenStreet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3Test {

	@Test
	void solution() {
		Solution3 solution3 = new Solution3();
		Assertions.assertEquals(0, solution3.solution(new int[]{1}));
	}
}