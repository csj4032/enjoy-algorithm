package countingElements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogRiverOneTest {

	FrogRiverOne frogRiverOne;

	@BeforeEach
	void setUp() {
		frogRiverOne = new FrogRiverOne();
	}

	@Test
	void solution() {
		int result = frogRiverOne.solution(1, new int[]{1});
		Assertions.assertEquals(0, result);

		result = frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
		Assertions.assertEquals(6, result);

		result = frogRiverOne.solution(5, new int[]{3});
		Assertions.assertEquals(-1, result);

		result = frogRiverOne.solution(2, new int[]{1, 1, 1, 1});
		Assertions.assertEquals(-1, result);

		result = frogRiverOne.solution(2, new int[]{2, 2, 2, 2, 2});
		Assertions.assertEquals(-1, result);
	}
}