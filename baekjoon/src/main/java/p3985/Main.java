package p3985;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int n = sc.nextInt();
		int[] k = new int[l + 1];
		Arrays.fill(k, -1);
		int t = 0, q = 0, x = 0, z = 0;
		for (int i = 1; i <= n; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int a = 0, b = 0;
			for (int j = s; j <= e; j++) {
				a++;
				if (k[j] == -1) {
					k[j] = i;
					b++;
				}
			}
			if (a > x) {
				x = a;
				t = i;
			}
			if (b > z) {
				z = b;
				q = i;
			}
		}
		System.out.println(t);
		System.out.println(q);
	}
}
