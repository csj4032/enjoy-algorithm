package p1365;

import java.io.*;

/**
 * 제목 : 꼬인 전깃줄
 * 링크 : https://www.acmicpc.net/problem/1365
 * 분류 : LIS, Lower Bound
 * 참고 : https://mygumi.tistory.com/303, https://yhwan.tistory.com/18
 */
public class Main {

	private static int dp[];
	private static int m[];
	private static int k;
	private static int n;
	private static String nn[];

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		nn = br.readLine().split(" ");
		m = new int[n];
		dp = new int[n];

		for (int i = 0; i < n; i++) m[i] = Integer.parseInt(nn[i]);

		dp[0] = m[0];
		int idx = 0;
		for (int i = 1; i < n; i++) {
			if (dp[idx] < m[i]) {
				dp[++idx] = m[i];
			} else {
				dp[lowerBound(0, idx, m[i], dp) - 1] = m[i];
			}
		}

		for (int i = 0; i < n; i++) if (dp[i] > 0) k++;
		System.out.println(n - k);
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
