package p2579;

import java.util.Scanner;

/**
 * 제목 : 계단 오르기
 * 링크 : https://www.acmicpc.net/problem/2579
 * 분류 : 다이나믹 프로그래밍
 * 
 * 문제 해설:
 * - 계단을 오르면서 얻을 수 있는 점수의 최댓값을 구하는 문제
 * - 규칙:
 *   1) 계단은 한 번에 1개 또는 2개씩 오를 수 있음
 *   2) 연속된 3개의 계단을 모두 밟으면 안됨
 *   3) 마지막 계단은 반드시 밟아야 함
 * 
 * DP 설계:
 * - dp[i] = i번째 계단을 밟았을 때 얻을 수 있는 최대 점수
 * - 점화식: dp[i] = max(dp[i-2], dp[i-3] + m[i-1]) + m[i]
 *   · case 1: i-2번째 계단에서 2칸 오른 경우 → dp[i-2] + m[i]
 *   · case 2: i-3번째→i-1번째→i번째로 온 경우 → dp[i-3] + m[i-1] + m[i]
 * 
 * 주의: 현재 코드의 인덱싱 방식을 확인하고 수정이 필요할 수 있음
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n + 1];  // 각 계단의 점수 (1-indexed로 사용)
		int[] dp = new int[n + 1]; // DP 배열

		// 계단 점수 입력 (1-indexed)
		for (int i = 1; i <= n; i++) {
			m[i] = sc.nextInt();
		}

		// 기저 조건 설정
		if (n >= 1) dp[1] = m[1];
		if (n >= 2) dp[2] = m[1] + m[2];
		if (n >= 3) dp[3] = Math.max(m[1] + m[3], m[2] + m[3]);

		// DP 계산
		for (int i = 4; i <= n; i++) {
			// case 1: i-2에서 2칸 오른 경우 vs case 2: i-3→i-1→i로 온 경우
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + m[i - 1]) + m[i];
		}

		System.out.println(dp[n]);
	}
}