package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class LongJumpTest {

	@Test
	public void test() {
		LongJump longJump = new LongJump();
		Assertions.assertEquals(5, longJump.solution(4));
		Assertions.assertEquals(3, longJump.solution(3));
	}
}