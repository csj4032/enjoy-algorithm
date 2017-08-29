package p2749;

import java.util.Scanner;

/**
 * 제목 : 피보나치 수 3
 * 단계 : 피보나치
 * 힌트 : 피사노 주기 (주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같다.)
 */
public class Main {

	static int m = 1000000;
	static int p = 1500000;
	static int[] fibonacci;

	static {
		fibonacci = new int[p];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		for (int i = 2; i < p; i++) {
			fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
			fibonacci[i] %= m;
		}
		System.out.println(fibonacci[(int) (n % p)]);
	}
}