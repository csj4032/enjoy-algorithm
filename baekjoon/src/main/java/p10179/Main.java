package p10179;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			BigDecimal bigDecimal = new BigDecimal(str);
			BigDecimal price = bigDecimal.subtract(bigDecimal.multiply(new BigDecimal("0.2")));
			System.out.println("$"+price.setScale(2, RoundingMode.HALF_UP));
		}
	}
}