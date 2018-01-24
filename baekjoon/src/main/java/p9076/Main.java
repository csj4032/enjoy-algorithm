package p9076;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int[] m = new int[5];
			for (int j = 0; j < 5; j++) {
				m[j] = sc.nextInt();
			}
			Arrays.sort(m);
			if (m[3] - m[1] > 3) {
				System.out.println("KIN");
			} else {
				System.out.println(m[1] + m[2] + m[3]);
			}
		}
	}
}