package p9613;

import java.util.Scanner;

/**
 * 제목 : GCD 합
 * 링크 : https://www.acmicpc.net/problem/9613
 * 분류 : GCD, 최대공약수
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var t = sc.nextInt();
		var sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			var l = sc.nextInt();
			var ll = new long[l];
			for (int j = 0; j < l; j++) ll[j] = sc.nextInt();
			var g = 0l;
			for (int j = 0; j < l; j++) {
				for (int k = j + 1; k < l; k++) {
					var a = ll[j];
					var b = ll[k];
					var c = gcd(a, b);
					g += c;
				}
			}
			sb.append(g).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
