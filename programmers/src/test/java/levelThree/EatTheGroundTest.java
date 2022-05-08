package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EatTheGroundTest {

	@Test
	public void test() {
		EatTheGround eatTheGround = new EatTheGround();
		Assertions.assertEquals(16, eatTheGround.solution(new int[][]{
				{1, 2, 3, 5},
				{5, 6, 7, 8},
				{4, 3, 2, 1}
		}));
	}
}