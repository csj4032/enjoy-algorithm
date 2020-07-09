package p14489;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var a = sc.nextLong();
		var b = sc.nextLong();
		var c = sc.nextLong();
		var d = c * 2;
		if ((a + b) >= d) {
			System.out.println(a + b - d);
		} else {
			System.out.println(a + b);
		}
	}
}
