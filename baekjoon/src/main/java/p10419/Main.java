package p10419;

import java.util.Scanner;

/**
 * 제목 : 지각
 * 링크 : https://www.acmicpc.net/problem/10419
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			var d = sc.nextInt();
			for (int j = 0; j <= d; j++) {
				double s = Math.pow(j, 2);
				if (d < s + j) {
					System.out.println(j - 1);
					break;
				}
			}
		}
	}
}