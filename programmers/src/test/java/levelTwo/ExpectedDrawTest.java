package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExpectedDrawTest {

	@Test
	public void test() {
		ExpectedDraw expectedDraw = new ExpectedDraw();
		Assertions.assertEquals(1, expectedDraw.solution(2, 1, 2));
		Assertions.assertEquals(1, expectedDraw.solution(8, 1, 2));
		Assertions.assertEquals(1, expectedDraw.solution(8, 7, 8));
		Assertions.assertEquals(3, expectedDraw.solution(16, 1, 8));
		Assertions.assertEquals(1, expectedDraw.solution(16, 15, 16));
		Assertions.assertEquals(1, expectedDraw.solution(32, 15, 16));
	}
}