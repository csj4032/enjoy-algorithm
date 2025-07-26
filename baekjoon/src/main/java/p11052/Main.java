package p11052;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 11052번: 카드 구매하기 (Silver 1)
 * https://www.acmicpc.net/problem/11052
 * 
 * == 문제 분류 ==
 * 동적 계획법, 배낭 문제
 * 
 * == 알고리즘 이론 ==
 * 1. 무한 배낭 문제 (Unbounded Knapsack)
 *    - 각 카드팩을 무제한으로 사용 가능
 *    - 최대 가치를 구하는 문제
 *    - dp[i] = i개의 카드를 얻기 위한 최대 비용
 * 
 * 2. 가치 최대화 문제
 *    - 동전 문제와 유사하지만 최댓값을 구함
 *    - 각 카드팩의 가성비를 고려한 선택
 * 
 * == 핵심 아이디어 ==
 * 1. dp[j] = max(dp[j], dp[j-i] + price[i])
 * 2. 각 카드팩에 대해 모든 가능한 조합 탐색
 * 3. 탐욕적 선택보다 DP로 최적해 보장
 * 
 * == 시간복잡도 ==
 * O(n²) - n: 카드 개수
 * 
 * == 공간복잡도 ==
 * O(n) - 1차원 DP 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 1차원 DP로 메모리 효율성
 * 2. 순차 탐색으로 중복 선택 허용
 * 
 * == 실무 응용 ==
 * - 상품 번들 할인 최적화
 * - 구매 전략 수립
 * - 가격 책정 전략
 * 
 * == 관련 심화 문제 ==
 * - 백준 2293: 동전 1
 * - 백준 1463: 1로 만들기
 * - 백준 9095: 1, 2, 3 더하기
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] p = new int[n + 1];
		int[] d = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			p[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (d[j] < d[j - i] + p[i]) {
					d[j] = d[j - i] + p[i];
				}
			}
		}
		System.out.println(Arrays.stream(d).max().orElse(0));
	}
}