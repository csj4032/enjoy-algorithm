package p2156;

import java.util.Scanner;

/**
 * 백준 2156번: 포도주 시식 (Silver 1)
 * https://www.acmicpc.net/problem/2156
 * 
 * 문제 분류: 동적 계획법(DP)
 * 핵심 알고리즘: 조건부 최대값 DP
 * 
 * 해결 접근 방법:
 * 1. 포도주를 연속으로 3잔 마실 수 없다는 제약 조건
 * 2. dp[i] = i번째까지 포도주 중에서 마실 수 있는 최대 양
 * 3. i번째 포도주를 마시는 경우의 수:
 *    - i-1번째를 마시지 않고 i번째를 마시는 경우: dp[i-2] + wine[i]
 *    - i-1번째를 마시고 i번째도 마시는 경우: dp[i-3] + wine[i-1] + wine[i]
 *    - i번째를 마시지 않는 경우: dp[i-1]
 * 4. 위 세 경우 중 최대값을 선택
 * 
 * 시간복잡도: O(N) - 배열을 한 번만 순회
 * 공간복잡도: O(N) - DP 테이블 저장
 * 
 * DP 상태 정의:
 * - dp[i]: i번째까지 고려했을 때 마실 수 있는 포도주의 최대 양
 * - 현재 잔을 마시는지 여부와 이전 잔을 마셨는지 여부를 고려
 * 
 * 제약 조건 처리:
 * - 연속 3잔 금지 → 이전 2잔의 상태를 고려한 점화식 설계
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 1-indexed로 사용하기 위해 n+1 크기로 생성
		int[] wine = new int[n + 1];
		int[] dp = new int[n + 1]; // dp[i] = i번째까지 고려한 최대 포도주 양

		// 포도주 양 입력
		for (int i = 1; i <= n; i++) {
			wine[i] = sc.nextInt();
		}

		// Base cases 처리
		if (n >= 1) {
			dp[1] = wine[1]; // 첫 번째만 마시는 경우
		}
		if (n >= 2) {
			dp[2] = wine[1] + wine[2]; // 첫 번째와 두 번째 모두 마시는 경우
		}

		// DP로 최대값 계산
		for (int i = 3; i <= n; i++) {
			// 세 가지 경우 중 최대값 선택
			dp[i] = Math.max(
				Math.max(
					dp[i - 2] + wine[i],           // i-1번째 안 마시고 i번째 마시기
					dp[i - 3] + wine[i - 1] + wine[i] // i-1번째와 i번째 연속으로 마시기
				),
				dp[i - 1]                          // i번째 마시지 않기
			);
		}

		System.out.println(dp[n]);
		sc.close();
	}
}