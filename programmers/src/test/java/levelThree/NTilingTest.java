package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NTilingTest {

	@Test
	public void test() {
		NTiling nTiling = new NTiling();
		Assertions.assertEquals(5, nTiling.solution(4));
	}
}