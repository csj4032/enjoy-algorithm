package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThreeNTilingTest {

	@Test
	void test(){
		ThreeNTiling threeNTiling = new ThreeNTiling();
		Assertions.assertEquals(11, threeNTiling.solution(4));
		Assertions.assertEquals(41, threeNTiling.solution(6));
		Assertions.assertEquals(153, threeNTiling.solution(8));
		Assertions.assertEquals(7953, threeNTiling.solution(14));
		Assertions.assertEquals(29681, threeNTiling.solution(16));
		Assertions.assertEquals(658712818, threeNTiling.solution(50000));
	}
}