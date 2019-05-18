package futureTraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StrSymmetryPointTest {

	StrSymmetryPoint strSymmetryPoint = new StrSymmetryPoint();

	@Test
	void solution() {
		int result = strSymmetryPoint.solution("AAA");
		Assertions.assertEquals(1, result);

		result = strSymmetryPoint.solution("AAAAA");
		Assertions.assertEquals(2, result);

		result = strSymmetryPoint.solution("AABCBAA");
		Assertions.assertEquals(3, result);
	}
}