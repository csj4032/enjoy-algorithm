package countingElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MaxCountersTest {

	@Test
	void solution() {
		MaxCounters maxCounters = new MaxCounters();
		int[] result = maxCounters.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
		Assertions.assertEquals("[3, 2, 2, 4, 2]", Arrays.toString(result));
		result = maxCounters.solution(5, new int[]{ 3, 4, 4, 6, 1, 4, 4, 6 });
		Assertions.assertEquals("[6, 6, 6, 6, 6]", Arrays.toString(result));
	}
}