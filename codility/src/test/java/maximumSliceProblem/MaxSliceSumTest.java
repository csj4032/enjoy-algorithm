package maximumSliceProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSliceSumTest {

	@Test
	void solution() {
		MaxSliceSum maxSliceSum = new MaxSliceSum();
		Assertions.assertEquals(5, maxSliceSum.solution(new int[]{3, 2, -6, 4, 0}));
		Assertions.assertEquals(10, maxSliceSum.solution(new int[]{-1, 10, -6, 4, 0}));
		Assertions.assertEquals(1, maxSliceSum.solution(new int[]{-2, 1}));
	}
}