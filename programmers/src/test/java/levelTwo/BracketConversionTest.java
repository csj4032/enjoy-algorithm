package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BracketConversionTest {

	@Test
	public void test() {
		BracketConversion bracketConversion = new BracketConversion();
		//Assertions.assertEquals("((())()(()))", bracketConversion.solution("()((())()))("));
		//Assertions.assertEquals("()", bracketConversion.solution(")("));
		Assertions.assertEquals("()(())()", bracketConversion.solution("()))((()"));
	}
}