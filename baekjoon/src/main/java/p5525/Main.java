package p5525;

import java.util.Scanner;

/**
 * 제목 : IOIOI
 * 링크 : https://www.acmicpc.net/problem/5525
 * 분류 : 기하 알고리즘
 */
public class Main {
	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = sc.nextInt();
		var s = sc.next();
		var t = ioi(n);
		var tt = t.length();
		var ttt = m - t.length();
		var k = 0;
		for (int i = 0; i < ttt + 1; i++) {
			if (s.substring(i, i + tt).hashCode() == t.hashCode()) k++;
		}
		System.out.println(k);
	}

	private static String ioi(int n) {
		var sb = "";
		for (int i = 0; i < n; i++) sb += "IO";
		sb += "I";
		return sb;
	}
}
