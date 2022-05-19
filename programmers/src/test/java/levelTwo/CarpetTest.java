package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarpetTest {

	@Test
	public void test() {
		Carpet carpet = new Carpet();
		Assertions.assertArrayEquals(new int[]{5, 5}, carpet.solution(16, 9));
		Assertions.assertArrayEquals(new int[]{4, 4}, carpet.solution(12, 4));
		Assertions.assertArrayEquals(new int[]{4, 4}, carpet.solution(13, 3));
		Assertions.assertArrayEquals(new int[]{3, 3}, carpet.solution(8, 1));
		Assertions.assertArrayEquals(new int[]{8, 6}, carpet.solution(24, 24));
	}
}