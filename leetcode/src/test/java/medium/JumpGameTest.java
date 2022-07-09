package medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpGameTest {

	@Test
	void test() {
		JumpGame jumpGame = new JumpGame();
		Assertions.assertEquals(true, jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
	}
}