package p1365;

import java.io.*;
import java.util.Arrays;

// https://yhwan.tistory.com/18
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String nn[] = br.readLine().split(" ");
		int m[] = new int[n];
		int dp[] = new int[n];
		int k = 0;

		for (int i = 0; i < n; i++) m[i] = Integer.parseInt(nn[i]);

		Arrays.fill(dp, 1);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (m[i] > m[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			k = Math.max(k, dp[i]);
		}
		System.out.println(n - k);
	}
}
