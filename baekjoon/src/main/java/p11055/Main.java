package p11055;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[1001];
		int dp[] = new int[1001];
		int sum[] = new int[1001];

		for (int i = 1; i <= n; i++) {
			int k = sc.nextInt();
			a[i] = k;
			sum[i] = k;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				//System.out.println("i : " + i + " " + "j : " + j + " a[i] : " + a[i] + " a[j] : " + a[j]);
				if (a[i] > a[j] && sum[i] < sum[j] + a[i]) {
					sum[i] = sum[j] + a[i];
				}
			}
		}
		//System.out.println(Arrays.toString(dp));
		//System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.stream(sum).max().orElse(0));
	}
}