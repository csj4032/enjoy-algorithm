package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HowToLineUpTest {

	@Test
	public void test() {
		HowToLineUp howToLineUp = new HowToLineUp();
		Assertions.assertArrayEquals(new int[]{1}, howToLineUp.solution(1, 1));
		Assertions.assertArrayEquals(new int[]{3, 1, 2}, howToLineUp.solution(3, 5));
		Assertions.assertArrayEquals(new int[]{1, 4, 2, 3}, howToLineUp.solution(4, 5));
		Assertions.assertArrayEquals(new int[]{2, 3, 4, 1}, howToLineUp.solution(4, 10));
		Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, howToLineUp.solution(20, 1));
	}
}