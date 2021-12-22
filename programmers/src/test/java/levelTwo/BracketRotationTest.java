package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BracketRotationTest {

	public int solution(String s) {
		BracketRotation bracketRotation = new BracketRotation();
		return bracketRotation.rotation(s);
	}

	@Test
	public void test() {
		Assertions.assertEquals(3, solution("[](){}"));
		Assertions.assertEquals(2, solution("}]()[{"));
		Assertions.assertEquals(0, solution("[)(]"));
		Assertions.assertEquals(0, solution("}}}"));
		Assertions.assertEquals(1, solution("{}"));
		Assertions.assertEquals(0, solution("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{"));
	}
}