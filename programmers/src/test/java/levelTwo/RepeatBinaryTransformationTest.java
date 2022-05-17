package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepeatBinaryTransformationTest {

	@Test
	public void test() {
		RepeatBinaryTransformation repeatBinaryTransformation = new RepeatBinaryTransformation();
		Assertions.assertArrayEquals(new int[]{3, 8}, repeatBinaryTransformation.solution("110010101001"));
		Assertions.assertArrayEquals(new int[]{3, 3}, repeatBinaryTransformation.solution("01110"));
		Assertions.assertArrayEquals(new int[]{4, 1}, repeatBinaryTransformation.solution("1111111"));
	}
}