package recursion;

import org.junit.jupiter.api.Test;

public class FactorialTest {

	@Test
	public void factorialTest() {
		Factorial factorial = new Factorial();
		System.out.println(factorial.factorial(10));
	}
}
