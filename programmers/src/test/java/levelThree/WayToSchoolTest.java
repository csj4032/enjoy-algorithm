package levelThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WayToSchoolTest {

	@Test
	void test() {
		WayToSchool wayToSchool = new WayToSchool();
		Assertions.assertEquals(4, wayToSchool.solution(4, 3, new int[][]{{2, 2}}));
	}
}