package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NQueenTest {

	@Test
	public void test() {
		NQueen nQueen = new NQueen();
		Assertions.assertEquals(2, nQueen.solution(4));
	}
}