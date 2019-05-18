package arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class OddOccurrencesInArrayTest {

	private static int[] n;

	@BeforeAll
	public static void setUp() {
		n = new int[]{9, 3, 9, 3, 9, 7, 9};
	}

	@Test
	public void test() {
		OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
		Assertions.assertEquals(7, oddOccurrencesInArray.solution(n));
	}
}