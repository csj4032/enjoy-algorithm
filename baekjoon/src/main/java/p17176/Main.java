package p17176;

import java.util.Scanner;

public class Main {

	static int[] m = new int[53];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var f = true;
		for (int i = 0; i < n; i++) m[sc.nextInt()]++;
		sc.nextLine();
		String s = sc.nextLine();
		for (int i = 0; i < n; i++) {
			var k = s.charAt(i) - 0;
			if (k > 96) {
				k = k - 70;
			} else if (k > 63 && k < 91) {
				k = k - 64;
			} else {
				k = 0;
			}
			m[k]--;
		}
		for (int i = 0; i < 53; i++) {
			if(m[i] != 0) {
				f = false;
				break;
			}
		}
		if (f) {
			System.out.println("y");
		} else {
			System.out.println("n");
		}
	}
}
