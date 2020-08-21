package p10972;

import java.util.Scanner;

/**
 * 제목 : 다음 순열
 * 링크 : https://www.acmicpc.net/problem/10972
 * 분류 : 수학
 * <p>
 * 1 2 3 4 (A > idx : 3, B > idx : 2)
 * 1 2 4 3
 * 1 3 2 4
 * 1 3 4 2
 * 1 4 3 2
 * 1 4 2 3
 * <p>
 * 앞 -> 뒤 방향으로 각각 비교 중 뒤 숫자가 큰 경우가 가장 뒤 발생 위치 (작은 숫자의 위치 A, 뒤쪽이 큰 경우가 없다면 종료 지점)
 * 뒤 -> A 방향으로 A 위치의 숫자 보다 큰 숫자들 중 가장 뒤에 위치 (큰 숫자 위치 B)
 * A 와 B Swap
 * A 뒤 부터 B 까지 단계 Swap
 */
public class Main {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var m = new int[n];
		var sb = new StringBuilder();
		for (int i = 0; i < n; i++) m[i] = sc.nextInt();
		var k = nextPermute(m);
		if (k == null) {
			System.out.println("-1");
		} else {
			for (int i = 0; i < n; i++) sb.append(m[i] + " ");
			System.out.println(sb.toString().trim());
		}
	}

	private static int[] nextPermute(int[] m) {
		var i = m.length - 1;
		var j = m.length - 1;
		while (i > 0 && m[i - 1] >= m[i]) --i;
		if (i <= 0) return null;
		while (m[i - 1] > m[j]) --j;
		swap(i - 1, j, m);
		j = m.length - 1;
		for (; i < j; ++i, --j) swap(i, j, m);
		return m;
	}

	private static void swap(int i, int j, int[] m) {
		var t = m[i];
		m[i] = m[j];
		m[j] = t;
	}
}
// 5
// 2 5 1 9 7
// 2 5 7 1 9

// 4
// 1 2 3 4
// 1 2 4 3

// 3
// 2 3 1
// 3 1 2

// 5
// 1 2 3 4 5
// 1 2 3 5 4
// 1 2 4 3 5
// 1 2 4 5 3
// 1 2 5 3 4
// 1 2 5 4 3 >> 1 3 5 4 2 >> 1 3 2 4 5
