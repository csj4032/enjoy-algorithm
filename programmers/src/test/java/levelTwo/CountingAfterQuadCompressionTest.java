package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountingAfterQuadCompressionTest {

	@Test
	void test() {
		CountingAfterQuadCompression countingAfterQuadCompression = new CountingAfterQuadCompression();
//		Assertions.assertArrayEquals(new int[]{4, 9}, countingAfterQuadCompression.solution(
//				new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}}
//		));

		Assertions.assertArrayEquals(new int[]{10, 15}, countingAfterQuadCompression.solution(
				new int[][]{
						{1, 1, 1, 1, 1, 1, 1, 1},
						{0, 1, 1, 1, 1, 1, 1, 1},
						{0, 0, 0, 0, 1, 1, 1, 1},
						{0, 1, 0, 0, 1, 1, 1, 1},
						{0, 0, 0, 0, 0, 0, 1, 1},
						{0, 0, 0, 0, 0, 0, 0, 1},
						{0, 0, 0, 0, 1, 0, 0, 1},
						{0, 0, 0, 0, 1, 1, 1, 1}}
		));
	}
}