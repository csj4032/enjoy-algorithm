package levelTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HIndexTest {

	private int solution(int[] citations) {
		HIndex hIndex = new HIndex();
		return hIndex.index(citations);
	}

	@Test
	public void test() {
		Assertions.assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
	}
}