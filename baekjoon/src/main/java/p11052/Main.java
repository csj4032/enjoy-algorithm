package p11052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n + 1];
		int[] d = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (d[j] < d[j - i] + p[i]) {
					d[j] = d[j - i] + p[i];
				}
			}
		}
		System.out.println(Arrays.stream(d).max().orElse(0));
	}
}