package p11728;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = Math.max(n, m);

		int nn[] = new int[k+1];
		int mm[] = new int[k+1];

		Arrays.fill(nn, 1000000001);
		Arrays.fill(mm, 1000000001);

		for (int i = 0; i < n; i++) {
			int q = sc.nextInt();
			nn[i] = q;
		}

		for (int i = 0; i < m; i++) {
			int q = sc.nextInt();
			mm[i] = q;
		}

		int q = 0;
		for (int i = 0; i <= k; i++) {
			for (int j = q; j <= k; j++) {
				if (nn[i] < mm[j]) {
					if(nn[i] != 1000000001) System.out.print(nn[i] + (i == k ? "" : " "));
					break;
				} else {
					if(mm[j] != 1000000001) System.out.print(mm[j] + (j == k ? "" : " "));
					q++;
				}
			}
		}
	}
}