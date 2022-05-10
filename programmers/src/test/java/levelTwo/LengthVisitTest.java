package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LengthVisitTest {

	@Test
	public void test() {
		LengthVisit lengthVisit = new LengthVisit();
		Assertions.assertEquals(7, lengthVisit.solution("ULURRDLLU"));
		Assertions.assertEquals(7, lengthVisit.solution("LULLLLLLU"));
	}
}