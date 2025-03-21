package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ExpressedAsNTest {

	@Test
	public void test(){
		ExpressedAsN expressedAsN = new ExpressedAsN();
		Assertions.assertEquals(4, expressedAsN.solution(5, 12));
		// Assertions.assertEquals(3, expressedAsN.solution(2, 11));
	}
}