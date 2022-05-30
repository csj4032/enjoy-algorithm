package levelFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SteppingStoneTest {

	@Test
	public void test() {
		SteppingStone steppingStone = new SteppingStone();
		Assertions.assertEquals(4, steppingStone.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
	}
}