package selection;

import java.util.Scanner;

import static java.lang.Math.min;

public class Inchworm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int S = sc.nextInt();
		int m[] = new int[n];
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
	}

	private static void solve(int n, int[] m, int s) {
		int r = n + 1;
		int lo = 0;
		int hi = 0;
		int sum = 0;
		for (; ; ) {
			while (lo < n && sum < s) {
				sum += m[lo++];
			}
			if (sum < s) break;
			r = min(r, lo - hi);
			sum -= m[hi++];
		}
	}
}
