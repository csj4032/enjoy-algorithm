package p1914;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 제목 : 하노이 탑 이동 순서
 * 링크 : https://www.acmicpc.net/problem/1914
 * 분류 : 분할정복
 * 메모 : 한 번에 하나의 원판만 옮길 수 있다. 큰 원판이 작은 원판 위에 있어서는 안 된다.
 * n 이 to 에서 from 가려면 n-1은 previous에 있어여 한다.
 * n = 3
 * 1 Start -> Destination
 * 2 From -> Pre
 * 1 To -> Pre
 * 3 From -> To
 * 1 To -> From
 * 2 Pre -> To
 * 1 From -> To
 *
 * n > 3 , 2^0 + 2^1 + 2^2 => 7
 * n > 4 , 2^0 + 2^1 + 2^2 + 2^3 => 15
 */
public class Main {

	static StringBuilder sb = new StringBuilder();
	static BigInteger nn = BigInteger.ZERO;
	static int m = 0;

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		if (n > 20) {
			for (int i = 0; i < n; i++) {
				nn = nn.add(BigInteger.valueOf(2).pow(i));
			}
			System.out.println(nn);
		} else {
			hanoi(n, 1, 3, 2);
			System.out.println(m);
			System.out.println(sb.toString());
		}
	}

	private static void hanoi(int n, int s, int d, int e) {
		if (n < 1) return;
		hanoi(n - 1, s, e, d);
		sb.append(s + " " + d + "\n");
		m++;
		hanoi(n - 1, e, d, s);
	}
}