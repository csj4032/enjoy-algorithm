package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JoyStickTest {

	@Test
	public void test() {
		JoyStick joyStick = new JoyStick();
		Assertions.assertEquals(56, joyStick.solution("JEROEN"));
		Assertions.assertEquals(23, joyStick.solution("JAN"));
	}
}