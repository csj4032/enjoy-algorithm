package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PairToRemoveTest {

	@Test
	public void test() {
		PairToRemove pairToRemove = new PairToRemove();
		Assertions.assertEquals(1, pairToRemove.solution("baabaa"));
		Assertions.assertEquals(0, pairToRemove.solution("cdcd"));
	}
}