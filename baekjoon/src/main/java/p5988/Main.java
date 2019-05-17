package p5988;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			BigInteger k = sc.nextBigInteger();
			if(k.mod(new BigInteger("2")).equals(new BigInteger("1"))) {
				System.out.println("odd");
			} else {
				System.out.println("even");
			}
		}
	}
}