package p2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static Integer[] n = new Integer[9];
	static int s = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			int k = sc.nextInt();
			n[i] = k;
			s += k;
		}

		for (int i = 0; i <= 7; i++) {
			for (int j = i + 1; j <= 8; j++) {
				if ((s - (n[i] + n[j])) == 100) {
					n[i] = 0;
					n[j] = 0;
					break;
				}
			}
		}

		Arrays.sort(n);

		for (int i = 0; i < 9; i++) {
			if (n[i] > 0) {
				System.out.println(n[i]);
			}
		}
	}
}