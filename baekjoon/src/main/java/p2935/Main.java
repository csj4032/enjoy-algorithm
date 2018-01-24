package p2935;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String o = sc.next();
		String b = sc.next();

		BigDecimal n = new BigDecimal(a);
		BigDecimal m = new BigDecimal(b);

		if(o.equals("+")) {
			BigDecimal k = n.add(m);
			System.out.println(k);
		}

		if(o.equals("*")) {
			BigDecimal k = n.multiply(m);
			System.out.println(k);
		}
	}
}