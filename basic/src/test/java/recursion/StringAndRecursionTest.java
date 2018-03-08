package recursion;

import org.junit.Before;
import org.junit.Test;

public class StringAndRecursionTest {

	private StringAndRecursion stringAndRecursion;

	@Before
	public void setUp() {
		stringAndRecursion = new StringAndRecursion();
	}

	@Test
	public void lengthTest() {
		System.out.println(stringAndRecursion.length("ABC"));
	}

	@Test
	public void printTest() {
		stringAndRecursion.print("ABC");
	}

	@Test
	public void printReverseTest() {
		stringAndRecursion.printCharReverse("ABC");
	}
}
