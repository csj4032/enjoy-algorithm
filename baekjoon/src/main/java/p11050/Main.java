package p11050;

import java.util.Scanner;

/**
 * 제목 : 이항 계수 1
 * 단계 : 이항 계수
 * 힌트 : http://destiny738.tistory.com/194
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int s = +recursive(n, k);
		System.out.println(s);
	}

	private static int recursive(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		return recursive(n - 1, k - 1) + recursive(n - 1, k);
	}
}