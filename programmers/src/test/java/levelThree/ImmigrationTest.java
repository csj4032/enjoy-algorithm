package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImmigrationTest {

	@Test
	public void test() {
		Immigration immigration = new Immigration();
		Assertions.assertEquals(28, immigration.solution(6, new int[]{7, 10}));
	}
}