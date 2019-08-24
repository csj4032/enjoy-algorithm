package recursion;

import org.junit.jupiter.api.Test;

public class ArrayAndRecursionTest {

	@Test
	public void sumTest() {
		ArrayAndRecursion arrayAndRecursion = new ArrayAndRecursion();
		System.out.println(arrayAndRecursion.sum(10, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
}
