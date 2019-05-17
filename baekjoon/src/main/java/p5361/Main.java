package p5361;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	static String[] table = new String[]{"350.34", "230.90", "190.55", "125.30", "180.90"};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			BigDecimal sum = BigDecimal.ZERO;
			for (int j = 0; j < 5; j++) {
				sum = sum.add(new BigDecimal(table[j]).multiply(new BigDecimal(sc.next())));
			}
			System.out.println("$" + sum);
		}
	}
}