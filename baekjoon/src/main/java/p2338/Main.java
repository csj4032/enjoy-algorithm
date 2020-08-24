package p2338;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextBigInteger();
		var b = sc.nextBigInteger();
		var aa = a.add(b);
		var bb = a.subtract(b);
		var cc = a.multiply(b);
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(cc);
	}
}
