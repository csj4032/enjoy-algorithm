package p2502;

import java.util.Scanner;

public class Main {

	static int[] d;
	static int a;
	static int b;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		d = new int[32];
		label:
		for (int i = 1; i < 100000; i++) {
			for (int j = i + 1; j < 100000; j++) {
				d[0] = i;
				d[1] = j;
				if (check()) {
					System.out.println(d[0]);
					System.out.println(d[1]);
					break label;
				}
			}
		}
	}

	private static boolean check() {
		for (int i = 0; i < a; i++) d[i + 2] = d[i] + d[i + 1];
		if (d[a - 1] == b) return true;
		return false;
	}
}
// 1 13 14 27 31 58