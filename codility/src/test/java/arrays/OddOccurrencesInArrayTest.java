package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OddOccurrencesInArrayTest {

	private static OddOccurrencesInArray oddOccurrencesInArray;

	@BeforeAll
	public static void setUp() {
		oddOccurrencesInArray = new OddOccurrencesInArray();
	}

	@Test
	void solution() {
		int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};
		Assertions.assertEquals(7, oddOccurrencesInArray.solution(A));
	}

	@Test
	void solution2() {
		int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};
		Assertions.assertEquals(7, oddOccurrencesInArray.solution2(A));
	}
}