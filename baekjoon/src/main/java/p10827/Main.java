package p10827;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal bigDecimal = new BigDecimal(sc.next());
		System.out.println(bigDecimal.pow(sc.nextInt()).toPlainString());
	}
}
