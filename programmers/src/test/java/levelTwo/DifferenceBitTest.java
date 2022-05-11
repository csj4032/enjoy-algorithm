package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DifferenceBitTest {
	@Test
	public void test() {
		DifferenceBit differenceBit = new DifferenceBit();
		Assertions.assertArrayEquals(new long[]{1, 2, 3, 6, 7, 11, 9, 11, 13}, differenceBit.solution(new long[]{0, 1, 2, 5, 6, 7, 8, 10, 11}));
	}
}