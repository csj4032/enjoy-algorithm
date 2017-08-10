import java.math.BigDecimal;
import java.util.Scanner;

public class SameNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigDecimal n = sc.nextBigDecimal();
		BigDecimal t = n;
		BigDecimal r = BigDecimal.ZERO;

		while (true) {
			t = t.divide(BigDecimal.TEN);
			if (t.compareTo(BigDecimal.ONE) == -1) {
				break;
			}
			r = r.add(BigDecimal.ONE);
		}

		BigDecimal a = pow(r);
		BigDecimal c = n.subtract(a);

		if (c.compareTo(a) == -1 && r.compareTo(BigDecimal.ONE) == 1) {
			c = n.subtract(a.divide(BigDecimal.TEN));
		}

		String d = String.valueOf(c);
		StringBuffer e = new StringBuffer(d.substring(0, d.length() - (c.compareTo(BigDecimal.valueOf(2)) == 1 ? 1 : 0)));
		System.out.println(d + "" + e.reverse());
	}


	private static BigDecimal pow(BigDecimal r) {
		BigDecimal c = BigDecimal.ZERO;
		BigDecimal d = BigDecimal.ONE;
		while (c.compareTo(r) == -1) {
			d = d.multiply(BigDecimal.TEN);
			c = c.add(BigDecimal.ONE);
		}
		return d;
	}
}

//		BigDecimal n = sc.nextBigDecimal();
//		BigDecimal i = BigDecimal.ZERO;
//		BigDecimal c = BigDecimal.ZERO;
//
//		while (true) {
//			StringBuffer s = new StringBuffer(i.toString());
//			StringBuffer sb = new StringBuffer(i.toString());
//			if (s.toString().equals(sb.reverse().toString())) {
//				c = c.add(BigDecimal.ONE);
//				if (c.compareTo(n) == 0) {
//					System.out.println("Same : " + sb);
//					break;
//				}
//			}
//			i = i.add(BigDecimal.ONE);
//		}
