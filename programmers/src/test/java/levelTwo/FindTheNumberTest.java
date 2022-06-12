package levelTwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheNumberTest {

	@Test
	public void test() {
		FindTheNumber findTheNumber = new FindTheNumber();
		assertEquals(1, findTheNumber.solution( 1, 10));
		//assertEquals(2, findTheNumber.solution(110011, 10));
	}
}