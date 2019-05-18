package futureTraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayInversionCountTest {

	@Test
	void solution() {
		ArrayInversionCount arrayInversionCount = new ArrayInversionCount();
		int result = arrayInversionCount.solution(new int[]{-1, 6, 3, 4, 7, 4});
		Assertions.assertEquals(4, result);
		result = arrayInversionCount.solution(new int[]{10, 2, 1, 4, 1, -1, 19, 1});
		Assertions.assertEquals(16, result);
	}
}
