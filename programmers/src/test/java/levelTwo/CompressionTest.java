package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompressionTest {

	@Test
	public void test() {
		Compression compression = new Compression();
		Assertions.assertArrayEquals(new int[]{11, 1, 27, 15}, compression.solution("KAKAO"));
		Assertions.assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, compression.solution("TOBEORNOTTOBEORTOBEORNOT"));
		Assertions.assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, compression.solution("ABABABABABABABAB"));
	}
}