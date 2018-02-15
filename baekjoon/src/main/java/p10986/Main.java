package p10986;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = 0;
		int[] mm = new int[n];
		int[] ss = new int[n];

		mm[0] = sc.nextInt();
		ss[0] = mm[0];

		for (int i = 1; i < n; i++) {
			mm[i] = sc.nextInt();
			ss[i] = ss[i - 1] + mm[i];
		}

		//System.out.println(Arrays.toString(mm));
		//System.out.println(Arrays.toString(ss));

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (ss[j] % m == 0) k++;
				ss[j] -= mm[i];
			}
		}

		System.out.println(k);
	}
}