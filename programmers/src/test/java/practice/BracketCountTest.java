package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BracketCountTest {

	@Test
	public void test() {
		BracketCount bracketCount = new BracketCount();
		Assertions.assertEquals(2, bracketCount.solution(2));
		//Assertions.assertEquals(5, bracketCount.solution(3));
	}
}