package p11053;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n + 1];
		int[] d = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i] > a[j] && d[i] == d[j]) {
					d[i] = d[i] + 1;
				}
			}
		}

		//System.out.println(Arrays.toString(d));
		System.out.println(Arrays.stream(d).max().orElse(0));
	}
}