package p12015;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 가장 긴 증가하는 부분 수열 2
 * 링크 : https://www.acmicpc.net/problem/12015
 * 분류 : LIS, Lower Bound
 * 참고 : https://mygumi.tistory.com/303, https://yhwan.tistory.com/18
 */
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

		Arrays.fill(dp, 0);
		dp[0] = m[0];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			if (dp[idx] < m[i]) {
				dp[++idx] = m[i];
			} else {
				dp[lowerBound(0, idx, m[i], dp) - 1] = m[i];
			}
		}

		//System.out.println(Arrays.toString(dp));

		for (int i = 0; i < n; i++) {
			if (dp[i] > 0) k++;
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