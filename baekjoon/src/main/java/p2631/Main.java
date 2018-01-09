package p2631;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			d[i] = 1;
			for (int j = 1; j < i; j++) {
				//System.out.println("i = " + i + " : j = " + j + " m[j] = " + m[j] + " m[i] = " + m[i] + " : d[i] = " + d[i] + " d[j] = " + d[j]);
				if (m[j] < m[i] && d[i] < d[j] + 1) {
					d[i]++;
				}
			}
		}
	}
}