package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SchedulingTest {

	@Test
	void test() {
		Scheduling scheduling = new Scheduling();
		//Assertions.assertEquals(2, scheduling.solution(6, new int[]{1, 2, 3}));
		Assertions.assertEquals(3, scheduling.solution(8, new int[]{1, 2, 3}));
		//Assertions.assertEquals(1, scheduling.solution(3, new int[]{1, 2}));
	}
}