package p15953;

import java.util.Scanner;

public class Main {

	private static int[] aa = {0, 1, 3, 6, 10, 15, 21};
	private static int[] aaa = {0, 5000000, 3000000, 2000000, 500000, 300000, 100000};
	private static int[] bb = {0, 1, 3, 7, 15, 31};
	private static int[] bbb = {0, 5120000, 2560000, 1280000, 640000, 320000};

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			var a = sc.nextInt();
			var b = sc.nextInt();
			var c = 0;
			for (int j = 0; j <= 6; j++) {
				if (a <= aa[j]) {
					c += aaa[j];
					break;
				}
			}
			for (int j = 0; j <= 5; j++) {
				if (b <= bb[j]) {
					c += bbb[j];
					break;
				}
			}
			System.out.println(c);
		}
	}
}
