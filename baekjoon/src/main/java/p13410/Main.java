package p13410;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int max = 0;

		for (int i = n; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				StringBuilder sb = new StringBuilder();
				int t = Integer.valueOf(sb.append(String.valueOf(i*j)).reverse().toString());
				if(max < t) {
					max = t;
				}
			}
		}
		System.out.println(max);
	}
}