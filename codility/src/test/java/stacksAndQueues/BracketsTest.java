package stacksAndQueues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsTest {

	@Test
	void solution() {
		Brackets brackets = new Brackets();
		Assertions.assertEquals(0, brackets.solution("())(()"));
		Assertions.assertEquals(1, brackets.solution("{[()()]}"));
		Assertions.assertEquals(0, brackets.solution("}]"));
		Assertions.assertEquals(0, brackets.solution("([)()]"));
		Assertions.assertEquals(0, brackets.solution("([)()]]"));
	}
}