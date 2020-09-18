package p18415;

import java.util.Scanner;

public class Main {

	private static int b;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var s = sc.next();
		var r = s.replaceAll("joi", "JOI");
		System.out.println(r);
	}
}