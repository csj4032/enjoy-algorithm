package p11659;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] m = new int[n];
		int[] l = new int[t];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 0; i < t; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			l[i] = sectionSum(s - 1, e - 1, m);
		}

		Arrays.stream(l).forEach(System.out::println);
	}

	private static int sectionSum(int s, int e, int[] m) {
		int k = 0;
		for (int i = s; i <= e; i++) {
			k += m[i];
		}
		return k;
	}
}
