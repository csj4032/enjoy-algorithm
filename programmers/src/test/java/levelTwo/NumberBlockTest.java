package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberBlockTest {

	@Test
	void test() {
		NumberBlock numberBlock = new NumberBlock();
		Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 3, 1, 4, 3, 5}, numberBlock.solution(1, 10));
		Assertions.assertArrayEquals(new int[]{0, 10, 0, 0, 15}, numberBlock.solution(10, 15));
	}
}