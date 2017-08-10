import java.math.BigDecimal;
import java.util.Scanner;

public class Fibonacci3 {

	//1000000000000000

	public static void main(String[] args) {
		BigDecimal l = BigDecimal.valueOf(4294967291L);
		BigDecimal f = BigDecimal.ZERO;
		BigDecimal s = BigDecimal.ONE;
		BigDecimal t;

		long m = new Scanner(System.in).nextLong();
		for (long i = 2; i <= m; i++) {
			t = f;
			f = f.add(s);
			s = t;

			// f += s;
			// s = f - s;
		}

		//System.out.println(f);
		System.out.println(f.remainder(l));
	}
}