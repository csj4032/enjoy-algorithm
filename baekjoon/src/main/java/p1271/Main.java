package p1271;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextBigInteger();
		var m = sc.nextBigInteger();

		var nn = n.divide(m);
		var mm = n.mod(m);

		System.out.println(nn);
		System.out.println(mm);
	}
}
