package p12865;

import java.util.*;

/**
 * 제목 : 평범한 배낭
 * 링크 : https://www.acmicpc.net/problem/12865
 * 분류 : 다이나믹 프로그래밍, 배낭 문제
 * 
 * === 문제 해설 ===
 * 0-1 배낭 문제(0-1 Knapsack Problem)의 고전적인 구현입니다.
 * N개의 물건과 무게 한계 K인 배낭이 주어질 때, 가치의 합을 최대화하는 문제입니다.
 * 각 물건은 하나씩만 선택할 수 있습니다 (0개 또는 1개).
 * 
 * === 수학적/이론적 배경 ===
 * 1) 0-1 배낭 문제의 최적 부분 구조:
 *    - 물건 i를 포함하는 경우: dp[i-1][w-weight[i]] + value[i]
 *    - 물건 i를 포함하지 않는 경우: dp[i-1][w]
 *    - 두 경우 중 최댓값을 선택
 * 
 * 2) 점화식 정의:
 *    - dp[i][w] = i번째 물건까지 고려하고 무게 w일 때의 최대 가치
 *    - dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])
 *    - 단, weight[i] <= w 조건 만족 시에만 포함 가능
 * 
 * 3) 경계 조건:
 *    - dp[0][w] = 0 (물건이 없으면 가치는 0)
 *    - dp[i][0] = 0 (배낭 용량이 0이면 가치는 0)
 * 
 * === 알고리즘 설계 ===
 * 1) 2차원 DP 테이블: dp[n+1][k+1]
 * 2) Bottom-up 방식으로 모든 상태 계산
 * 3) 각 물건에 대해 포함/미포함 결정
 * 4) 무게 제약 조건 검사 후 최적값 선택
 * 
 * === 최적화 기법 ===
 * 1) 공간 복잡도 최적화:
 *    - 이전 행만 참조하므로 1차원 배열로 축소 가능
 *    - 역순으로 갱신하여 덮어쓰기 방지
 * 2) 가지치기 최적화:
 *    - 무게가 배낭 용량을 초과하는 경우 조기 종료
 * 3) 메모리 접근 패턴 최적화:
 *    - 캐시 친화적인 접근 순서
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(N × K) (N: 물건 개수, K: 배낭 용량)
 * - 공간복잡도: O(N × K) (2차원 DP 테이블)
 * - 최적화 시 공간복잡도: O(K) (1차원 배열)
 * 
 * === 대안 해결법 ===
 * 1) 1차원 DP 배열 사용 (공간 최적화)
 * 2) 메모이제이션을 이용한 Top-down DP
 * 3) 분기한정법(Branch and Bound)
 * 4) 근사 알고리즘 (FPTAS - Fully Polynomial-Time Approximation Scheme)
 * 5) 탐욕 알고리즘 (가치/무게 비율 기준 - 근사해)
 * 
 * === 변형 문제들 ===
 * 1) 무한 배낭 문제 (Unbounded Knapsack)
 * 2) 다중 배낭 문제 (Multiple Knapsack)
 * 3) 분할 가능 배낭 문제 (Fractional Knapsack)
 * 4) 다차원 배낭 문제
 * 
 * === 실제 응용 분야 ===
 * - 자원 할당 최적화
 * - 투자 포트폴리오 선택
 * - 프로젝트 선택 문제
 * - 로딩 계획 최적화
 */
public class Main {

	static int m[];
	static int w[];
	static int v[];
	static long dp[][];

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
		var n = sc.nextInt();
		var k = sc.nextInt();
		m = new int[n];
		w = new int[n];
		v = new int[n];
		dp = new long[n + 1][k + 1];

		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (w[i - 1] <= j) {
					dp[i][j] = Math.max(v[i - 1] + dp[i - 1][j - w[i - 1]], dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][k]);
		System.out.println(Arrays.deepToString(dp));
	}

	private static void display(long[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
/*
5 7
6 13
4 8
2 10
3 6
5 12

4 7
1 1000
2 1000
3 1000
5 1000

4 7
3 6
4 8
5 12
6 13

4 7
3 6
5 18
4 8
5 12

8 4
1 3
1 6
1 3
1 3
1 3
1 2
1 5
1 8

 */