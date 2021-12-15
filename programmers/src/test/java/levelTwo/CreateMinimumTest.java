package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateMinimumTest {

	@Test
	public void solution() {
		CreateMinimum createMinimum = new CreateMinimum();
		Assertions.assertEquals(28, createMinimum.solution(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
	}
}