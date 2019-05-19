package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {

	@Test
	void solution() {
		CyclicRotation cyclicRotation = new CyclicRotation();
		int[] result = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3);
		Assertions.assertArrayEquals(new int[]{9, 7, 6, 3, 8}, result);

		result = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 4);
		Assertions.assertArrayEquals(new int[]{8, 9, 7, 6, 3}, result);

		result = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 5);
		Assertions.assertArrayEquals(new int[]{3, 8, 9, 7, 6}, result);
	}
}