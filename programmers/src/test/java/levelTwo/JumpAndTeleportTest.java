package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JumpAndTeleportTest {

	@Test
	public void test() {
		JumpAndTeleport jumpAndTeleport = new JumpAndTeleport();
		Assertions.assertEquals(2, jumpAndTeleport.solution(5));
		Assertions.assertEquals(2, jumpAndTeleport.solution(6));
		Assertions.assertEquals(5, jumpAndTeleport.solution(5000));
	}
}