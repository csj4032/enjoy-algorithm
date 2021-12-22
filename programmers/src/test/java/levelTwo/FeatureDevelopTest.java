package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FeatureDevelopTest {

	public int[] solution(int[] progresses, int[] speeds) {
		FeatureDevelop featureDevelop = new FeatureDevelop();
		return featureDevelop.develop(progresses, speeds);
	}

	@Test
	public void test() {
		Assertions.assertArrayEquals(new int[]{2, 1}, solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
	}
}