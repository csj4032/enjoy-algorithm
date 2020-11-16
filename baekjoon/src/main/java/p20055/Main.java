package p20055;

import java.util.Scanner;

/**
 * 제목 : 컨베이어 벨트 위의 로봇
 * 링크 : https://www.acmicpc.net/problem/20055
 */
public class Main {

	private static int[] l;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		l = new int[n * 2];
		for (int i = 0; i < n * 2; i++) {
			l[i] = sc.nextInt();
		}
	}
}
