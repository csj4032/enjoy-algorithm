package p13900;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		BigDecimal k = new BigDecimal(0);
		BigDecimal l = new BigDecimal(0);

		for (int i = 0; i < n; i++) {
			int h = sc.nextInt();
			m[i] = h;
			k = k.add(new BigDecimal(h));
		}

		for (int i = 0; i < n; i++) {
			k = k.subtract(new BigDecimal(m[i]));
			l = l.add(new BigDecimal(m[i]).multiply(k));
		}

		System.out.println(l);
	}
}
