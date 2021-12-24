package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepresentationOfNumbersTest {

	public int solution(int n) {
		RepresentationOfNumbers representationOfNumbers = new RepresentationOfNumbers();
		return representationOfNumbers.numbers(n);
	}

	@Test
	public void test() {
		Assertions.assertEquals(4, solution(15));
	}
}