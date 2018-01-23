package p11054;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];

		int[] dp1 = new int[n];
		int[] dp2 = new int[n];

		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (m[j] < m[i] && dp1[i] < dp1[j] + 1) {
					dp1[i] = dp1[i]+1;
				}
			}
		}

		//System.out.println(Arrays.toString(dp1));

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (m[j] < m[i] && dp2[i] < dp2[j] + 1) {
					dp2[i] = dp2[i] + 1;
				}
			}
		}

		//System.out.println(Arrays.toString(dp2));

		int max = 0;
		for (int i = 0; i < n; i++) {
			int k = dp1[i] + dp2[i];
			if (k > max) max = k;
		}

		System.out.println(max - 1);
	}
}