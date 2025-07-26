package p9251;

import java.util.Scanner;

/**
 * 제목 : LCS (Longest Common Subsequence)
 * 링크 : https://www.acmicpc.net/problem/9251
 * 분류 : 다이나믹 프로그래밍, 문자열
 * 참고 : https://ko.wikipedia.org/wiki/최장_공통_부분_수열
 * 
 * === 문제 해설 ===
 * 두 문자열의 최장 공통 부분수열(LCS)의 길이를 구하는 문제입니다.
 * 부분수열은 원래 수열에서 일부 원소를 제거하여 만든 수열로, 순서는 유지되어야 합니다.
 * 
 * === 수학적/이론적 배경 ===
 * 1) LCS 문제의 최적 부분 구조:
 *    - X[1..m], Y[1..n]에 대해 LCS(X, Y)를 구할 때
 *    - X[m] == Y[n]이면: LCS(X, Y) = LCS(X[1..m-1], Y[1..n-1]) + 1
 *    - X[m] != Y[n]이면: LCS(X, Y) = max(LCS(X[1..m-1], Y), LCS(X, Y[1..n-1]))
 * 
 * 2) 점화식 정의:
 *    - dp[i][j] = X[1..i]와 Y[1..j]의 LCS 길이
 *    - dp[i][j] = dp[i-1][j-1] + 1 (if X[i] == Y[j])
 *    - dp[i][j] = max(dp[i-1][j], dp[i][j-1]) (if X[i] != Y[j])
 * 
 * 3) 경계 조건:
 *    - dp[0][j] = 0 (빈 문자열과의 LCS는 0)
 *    - dp[i][0] = 0 (빈 문자열과의 LCS는 0)
 * 
 * === 알고리즘 설계 ===
 * 1) 2차원 DP 테이블 생성: dp[m+1][n+1]
 * 2) Bottom-up 방식으로 테이블 채우기
 * 3) 문자 비교 후 점화식 적용
 * 4) dp[m][n]이 최종 답
 * 
 * === 최적화 기법 ===
 * 1) 공간 복잡도 최적화:
 *    - 이전 행만 필요하므로 1차원 배열로 축소 가능
 *    - 현재 구현: O(mn), 최적화 후: O(min(m,n))
 * 2) 문자열을 배열로 분할하여 처리 (현재 구현의 특징)
 * 
 * === 시간/공간 복잡도 ===
 * - 시간복잡도: O(m × n) (m, n은 각 문자열의 길이)
 * - 공간복잡도: O(m × n) (DP 테이블)
 * - 최적화 시 공간복잡도: O(min(m, n))
 * 
 * === 대안 해결법 ===
 * 1) 메모이제이션을 이용한 Top-down DP
 * 2) 공간 최적화 버전 (rolling array)
 * 3) LCS 추적 버전 (실제 공통 부분수열 출력)
 * 4) Hirschberg 알고리즘 (O(min(m,n)) 공간으로 실제 LCS 구성)
 * 
 * === 응용 분야 ===
 * - 유전자 서열 분석 (생물정보학)
 * - 파일 비교 도구 (diff 명령어)
 * - 편집 거리(Edit Distance) 계산
 * - 문서 유사도 측정
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(longestCommonSubsequence(a, b));
	}

	private static int longestCommonSubsequence(String str1, String str2) {
		String[] arr1 = str1.split("");
		String[] arr2 = str2.split("");

		int n = arr1.length;
		int m = arr2.length;

		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i < m; i++) dp[0][i] = 0;
		for (int i = 0; i < n; i++) dp[i][0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (arr1[i - 1].equals(arr2[j - 1])) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		return dp[n][m];
	}
}