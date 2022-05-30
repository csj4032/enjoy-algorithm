package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrossTheSteppingBridgeTest {

	@Test
	public void test() {
		CrossTheSteppingBridge crossTheSteppingBridge = new CrossTheSteppingBridge();
		Assertions.assertEquals(3, crossTheSteppingBridge.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
}