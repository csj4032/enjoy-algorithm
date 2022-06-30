package easy;

import easy.p1.TwoSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

	@Test
	void test() {
		TwoSum twoSum = new TwoSum();
		Assertions.assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
	}
}