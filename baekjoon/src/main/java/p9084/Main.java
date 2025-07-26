package p9084;

import java.util.Scanner;

/**
 * 백준 9084번: 동전 (Gold 5)
 * https://www.acmicpc.net/problem/9084
 * 
 * == 문제 분류 ==
 * 동적 계획법, 배낭 문제
 * 
 * == 알고리즘 이론 ==
 * 1. 동전 문제 (Coin Change Problem)
 *    - 백준 2293번과 동일한 문제
 *    - 무한 배낭 문제의 전형적인 예
 *    - 각 동전을 무제한으로 사용 가능
 * 
 * 2. 테스트케이스 처리
 *    - 여러 테스트케이스를 효율적으로 처리
 *    - 각 케이스마다 DP 배열 초기화 필요
 * 
 * == 핵심 아이디어 ==
 * 1. dp[i] = 금액 i를 만드는 경우의 수
 * 2. dp[amount] += dp[amount - coin]
 * 3. 동전 순서대로 처리하여 중복 제거
 * 
 * == 시간복잡도 ==
 * O(T * N * M) - T: 테스트케이스, N: 동전 종류, M: 목표 금액
 * 
 * == 공간복잡도 ==
 * O(M) - 목표 금액만큼의 DP 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 1차원 DP 배열로 공간 절약
 * 2. 테스트케이스별 배열 재사용
 * 3. 순차적 동전 처리로 중복 방지
 * 
 * == 실무 응용 ==
 * - 화폐 시스템 설계
 * - 자판기 거스름돈 계산
 * - 조합 최적화 문제
 * 
 * == 관련 심화 문제 ==
 * - 백준 2293: 동전 1 (동일 문제)
 * - 백준 2294: 동전 2 (최소 개수)
 * - 백준 11047: 동전 0 (그리디)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m[] = new int[n];

			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}

			int p = sc.nextInt();
			int[] dp = new int[p + 1];
			dp[0] = 1;

			for (int j = 0; j < n; j++) {
				for (int k = m[j]; k < p + 1; k++) {
					dp[k] += dp[k - m[j]];
				}
			}
			System.out.println(dp[p]);
		}
	}
}