package arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OddOccurrencesInArrayTest {

	private int[] n;

	@Before
	public void setUp() {
		n = new int[]{9, 3, 9, 3, 9, 7, 9};
	}

	@Test
	public void test() {
		OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();
		Assert.assertEquals(7, oddOccurrencesInArray.solution(n));
	}
}