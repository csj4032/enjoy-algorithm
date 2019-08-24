package recursion;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StringAndRecursionTest {

	private static StringAndRecursion stringAndRecursion;

	@BeforeAll
	public static void setUp() {
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
