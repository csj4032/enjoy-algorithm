package caterpillarMethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountDistinctSlicesTest {

	@Test
	void solution() {
		CountDistinctSlices countDistinctSlices = new CountDistinctSlices();
		int result = countDistinctSlices.solution(6, new int[]{1, 2, 3, 3, 3, 3, 3, 3, 3});
		System.out.println(result);
		result = countDistinctSlices.solution(6, new int[]{3, 4, 5, 5, 2});
		System.out.println(result);
	}
}