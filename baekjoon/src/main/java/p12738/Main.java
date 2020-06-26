package p12738;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = 0;
		int[] m = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		Arrays.fill(dp, -1000000001);
		dp[0] = m[0];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			if (dp[idx] < m[i]) {
				dp[++idx] = m[i];
			} else {
				dp[lowerBound(0, idx, m[i], dp) - 1] = m[i];
			}
		}

		for (int i = 0; i < n; i++) {
			if (dp[i] > -1000000001) k++;
		}

		System.out.println(k);
	}

	private static int lowerBound(int start, int end, int target, int[] list) {
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (list[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end + 1;
	}
}
