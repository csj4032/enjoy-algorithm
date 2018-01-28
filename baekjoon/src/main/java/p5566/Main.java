package p5566;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] nn = new int[n];
		int[] mm = new int[m];

		for (int i = 0; i < n; i++) {
			nn[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			mm[i] = sc.nextInt();
		}

		int k = 1;

		for (int i = 0; i < m; i++) {
			int t = mm[i];
			k += t;
			if (k >= n) {
				System.out.println(i + 1);
				break;
			}
			int q = nn[k - 1];
			if (q != 0) {
				k += q;
			}
			if (k >= n) {
				System.out.println(i + 1);
				break;
			}
		}
	}
}