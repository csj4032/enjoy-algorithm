package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TruckCrossingTheBridgeTest {

	@Test
	public void test() {
		TruckCrossingTheBridge truckCrossingTheBridge = new TruckCrossingTheBridge();
		Assertions.assertEquals(8, truckCrossingTheBridge.solution(2, 10, new int[]{7, 4, 5, 6}));
		//Assertions.assertEquals(101, truckCrossingTheBridge.solution(100, 100, new int[]{10}));
		Assertions.assertEquals(110, truckCrossingTheBridge.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	}
}