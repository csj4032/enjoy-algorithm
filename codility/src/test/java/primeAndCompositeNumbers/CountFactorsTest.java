package primeAndCompositeNumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountFactorsTest {

	@Test
	void solution() {
		CountFactors countFactors = new CountFactors();
		Assertions.assertEquals(1, countFactors.solution(1));
		Assertions.assertEquals(2, countFactors.solution(2));
		Assertions.assertEquals(8, countFactors.solution(24));
		Assertions.assertEquals(3, countFactors.solution(9));
	}
}