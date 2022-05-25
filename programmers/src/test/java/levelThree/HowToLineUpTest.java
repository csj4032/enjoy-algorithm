package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HowToLineUpTest {

	@Test
	public void test() {
		HowToLineUp howToLineUp = new HowToLineUp();
		Assertions.assertArrayEquals(new int[]{3, 1, 2}, howToLineUp.solution(3, 5));
	}
}