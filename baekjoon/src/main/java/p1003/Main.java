package p1003;

import java.util.Scanner;

/**
 * 제목 : 구현
 * 단계 : 피보나치 함수
 * 힌트 :
 */
public class Main {

	static int[] z = new int[41];
	static int[] o = new int[41];

	public static void main(String[] args) {

		z[0] = 1;
		z[1] = 0;

		o[0] = 0;
		o[1] = 1;

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			for (int j = 2; j <= n; j++) {
				z[j] = z[j - 2] + z[j - 1];
			}
			for (int j = 2; j <= n; j++) {
				o[j] = o[j - 2] + o[j - 1];
			}
			System.out.println(z[n] + " " + o[n]);
		}
	}
}