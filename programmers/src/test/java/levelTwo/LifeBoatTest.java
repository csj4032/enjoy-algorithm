package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LifeBoatTest {

	@Test
	public void test() {
		LifeBoat lifeBoat = new LifeBoat();
		Assertions.assertEquals(3, lifeBoat.solution(new int[]{70, 50, 80, 50}, 100));
		Assertions.assertEquals(3, lifeBoat.solution(new int[]{70, 80, 50}, 100));
		Assertions.assertEquals(2, lifeBoat.solution(new int[]{1, 3, 2, 2}, 4));
	}
}