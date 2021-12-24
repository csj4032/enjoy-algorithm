package kakaoInternship2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximizeFormulasTest {

	public long solution(String expression) {
		MaximizeFormulas maximizeFormulas = new MaximizeFormulas();
		return maximizeFormulas.reward(expression);
	}

	@Test
	public void test() {
		Assertions.assertEquals(60420, solution("100-200*300-500+20"));
		Assertions.assertEquals(300, solution("50*6-3*2"));
	}
}