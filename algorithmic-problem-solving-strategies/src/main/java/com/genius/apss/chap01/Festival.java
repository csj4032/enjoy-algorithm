package com.genius.apss.chap01;

import java.util.Scanner;

public class Festival {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var c = sc.nextInt();
		for (int i = 0; i < c; i++) {
			var n = sc.nextInt();
			var l = sc.nextInt();
			var m = new int[n];
			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}
			System.out.printf("%.10f\n", cost(n, l, m));
		}
	}

	private static float cost(int n, int l, int[] m) {
		float min = Integer.MAX_VALUE;
		for (int i = l; i <= n; i++) {
			for (int j = 0; j <= n - i; j++) {
				var sum = 0f;
				for (int k = j; k < i + j; k++) {
					sum += m[k];
				}
				min = Math.min(min, sum / i);
			}
		}
		return min;
	}
}
//2
//6 3
//1 2 3 1 2 3
//6 2
//1 2 3 1 2 3