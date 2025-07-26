package p2293;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 2293번: 동전 1 (Gold 5)
 * https://www.acmicpc.net/problem/2293
 * 
 * == 문제 분류 ==
 * 동적 계획법, 배낭 문제
 * 
 * == 알고리즘 이론 ==
 * 1. 동전 문제 (Coin Change Problem)
 *    - 무한 배낭 문제의 변형
 *    - 각 동전을 무한히 사용할 수 있음
 *    - dp[i] = 금액 i를 만들 수 있는 경우의 수
 * 
 * 2. 중복 조합 (Combination with Repetition)
 *    - 순서를 고려하지 않는 중복 선택
 *    - 동전의 순서는 중요하지 않음 (1+2 = 2+1)
 * 
 * == 핵심 아이디어 ==
 * 1. dp[j] += dp[j - coin[i]] 점화식
 * 2. 동전을 하나씩 고려하며 DP 테이블 갱신
 * 3. 중복을 피하기 위해 동전 순서대로 처리
 * 
 * == 시간복잡도 ==
 * O(n * k) - n: 동전 종류 수, k: 목표 금액
 * 
 * == 공간복잡도 ==
 * O(k) - 1차원 DP 배열 사용
 * 
 * == 구현 최적화 기법 ==
 * 1. 1차원 DP 배열로 공간 절약
 * 2. 역순 탐색으로 중복 계산 방지
 * 
 * == 실무 응용 ==
 * - 거스름돈 계산 시스템
 * - 자원 할당 최적화
 * - 조합론적 계산
 * 
 * == 관련 심화 문제 ==
 * - 백준 2294: 동전 2 (최소 동전 개수)
 * - 백준 9084: 동전 (동일 문제)
 * - 백준 2293: 동전 1 (경우의 수)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[n + 1];
		int[] dp = new int[m + 1];
		int[] dp2 = new int[m + 1];
		dp[0] = 1;

		Arrays.fill(dp2, 100000);
		dp2[0] = 0;

		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = l[i]; j <= m; j++) {
				dp[j] += dp[j - l[i]];
				dp2[j] = Math.min(dp2[j], dp2[j - l[i]]+1);
			}
			System.out.println();
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(dp2));
		System.out.println(dp[m]);
		System.out.println(dp2[m]);
	}
}
