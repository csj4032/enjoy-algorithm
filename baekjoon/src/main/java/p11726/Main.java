package p11726;

import java.util.Scanner;

/**
 * 제목 : 2×n 타일링
 * 링크 : https://www.acmicpc.net/problem/11726
 * 분류 : 동적프로그래밍
 * 
 * 문제 해설:
 * - 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 문제
 * - 2×1 타일: 세로로 놓는 타일 (높이가 2, 너비가 1)
 * - 1×2 타일: 가로로 놓는 타일 (높이가 1, 너비가 2이지만 2개를 세로로 쌓아야 함)
 * 
 * DP 설계:
 * - m[i] = 2×i 직사각형을 채우는 방법의 수
 * - 점화식: m[i] = m[i-1] + m[i-2]
 *   · 맨 끝에 2×1 타일 1개를 놓는 경우: m[i-1]가지
 *   · 맨 끝에 1×2 타일 2개를 놓는 경우: m[i-2]가지
 * - 초기값: m[0] = 1 (아무것도 놓지 않는 경우), m[1] = 1 (2×1 타일 1개)
 * 
 * 본질적으로 피보나치 수열과 동일한 구조
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];

		// 기저 조건 설정
		m[0] = 1;  // 2×0: 아무것도 놓지 않는 경우 1가지
		if (n >= 1) m[1] = 1;  // 2×1: 2×1 타일 1개만 놓는 경우 1가지

		// DP 계산: 피보나치 수열과 동일
		for (int i = 2; i <= n; i++) {
			m[i] = (m[i - 2] + m[i - 1]) % 10007;  // 모듈러 연산으로 오버플로우 방지
		}

		System.out.println(m[n]);
	}
}