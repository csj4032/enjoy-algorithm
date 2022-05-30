package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmigrationTest {

	@Test
	public void test() {
		Immigration immigration = new Immigration();
		Assertions.assertEquals(1, immigration.solution(1, new int[]{1, 1, 1}));
		Assertions.assertEquals(28, immigration.solution(6, new int[]{7, 10}));
		Assertions.assertEquals(2, immigration.solution(2, new int[]{1, 10}));
		Assertions.assertEquals(10, immigration.solution(2, new int[]{10, 10}));
		Assertions.assertEquals(3, immigration.solution(3, new int[]{1, 99, 99}));
		Assertions.assertEquals(30, immigration.solution(10, new int[]{6, 8, 10}));
	}
}