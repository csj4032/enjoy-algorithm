package medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumSubarrayTest {

	@Test
	void test() {
		MaximumSubarray maximumSubarray = new MaximumSubarray();
		Assertions.assertEquals(6, maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
		Assertions.assertEquals(1, maximumSubarray.maxSubArray(new int[]{-2, 1}));
		Assertions.assertEquals(-1, maximumSubarray.maxSubArray(new int[]{-2, -1}));
		Assertions.assertEquals(-1, maximumSubarray.maxSubArray(new int[]{-1, -2}));
	}
}