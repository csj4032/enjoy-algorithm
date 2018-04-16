package p10824;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	private static long E, F, p = 1, q = 1;
	private static long A, B, C, D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();

		BigInteger k = new BigInteger(String.valueOf(A) + String.valueOf(B));
		BigInteger m = new BigInteger(String.valueOf(C) + String.valueOf(D));

		System.out.println(k.add(m));

		E = B;
		F = D;

		while (E > 0) {
			E /= 10;
			p *= 10;
		}

		while (F > 0) {
			F /= 10;
			q *= 10;
		}

		System.out.println(A * p + B);
		System.out.println(C * q + D);
		System.out.println(A * p + B + C * q + D);
	}
}