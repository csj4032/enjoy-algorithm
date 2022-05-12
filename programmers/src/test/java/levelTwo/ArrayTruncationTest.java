package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayTruncationTest {

	@Test
	public void test() {
		ArrayTruncation arrayTruncation = new ArrayTruncation();
		Assertions.assertArrayEquals(new int[]{3, 2, 2, 3}, arrayTruncation.solution(3, 2, 5));
		Assertions.assertArrayEquals(new int[]{4, 3, 3, 3, 4, 4, 4, 4}, arrayTruncation.solution(4, 7, 14));
	}
}