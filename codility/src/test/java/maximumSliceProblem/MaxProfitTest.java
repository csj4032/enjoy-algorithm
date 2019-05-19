package maximumSliceProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

	@Test
	void solution() {
		MaxProfit maxProfit = new MaxProfit();
		int result = maxProfit.solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367});
		Assertions.assertEquals(356, result);

		result = maxProfit.solution(new int[]{1, 2, 3, 6, 3, 7});
		Assertions.assertEquals(6, result);

		result = maxProfit.solution(new int[]{8, 9, 3, 6, 1, 2});
		Assertions.assertEquals(3, result);
	}
}