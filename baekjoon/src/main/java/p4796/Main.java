package p4796;

import java.util.Scanner;

/**
 * 제목 : 캠핑
 * 링크 : https://www.acmicpc.net/problem/4796
 * 분류 : 수학, 그리디 알고리즘, 사칙연산
 * <p>
 * 2 8 20
 * 0 0 0
 * =====> 6
 * <p>
 * OOXXXXXX  OOXXXXXX  00XXXXXX
 * ||        ||        ||
 */
public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var sb = new StringBuilder();
		var k = 0L;
		while (true) {
			var l = sc.nextLong();
			var p = sc.nextLong();
			var v = sc.nextLong();
			if (l == 0L && p == 0L && v == 0L) break;
			k++;
			long vp = v / p;
			long lpv = Math.min(v % p, l);
			long t = (vp * l) + lpv;
			sb.append("Case " + k + ": " + t + "\n");
		}
		System.out.println(sb.toString());
	}
}
