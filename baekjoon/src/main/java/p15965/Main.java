package p15965;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static int ll = 100000000;
	private static int p[] = new int[ll];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var k = sc.nextInt();

		Arrays.fill(p, 1);

		p[0] = 0;
		p[1] = 0;

		for (int i = 2; (i * i) < ll; i++) {
			if (p[i] == 0) continue;
			for (int j = i * i; j < ll; j += i) {
				p[j] = 0;
			}
		}

		var t = 0;
		for (int i = 0; i < ll; i++) {
			t += p[i];
			if (t == k) {
				System.out.println(i);
				break;
			}
		}
	}
}
