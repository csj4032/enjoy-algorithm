package recursion;

import org.junit.Test;

public class EuclidMethodTest {

	@Test
	public void gcdTest() {
		EuclidMethod euclidMethod = new EuclidMethod();
		System.out.println(euclidMethod.gcd(25, 30));
		System.out.println(euclidMethod.gcd2(25, 30));
		System.out.println(euclidMethod.gcd2(30, 25));
	}
}
