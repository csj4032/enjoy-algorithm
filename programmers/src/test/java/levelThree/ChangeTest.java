package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChangeTest {

	@Test
	public void test() {
		Change change = new Change();
		Assertions.assertEquals(4, change.solution(5, new int[]{1, 2, 5}));
	}
}