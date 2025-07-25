package p10844;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 제목 : 쉬운 계단 수
 * 링크 : https://www.acmicpc.net/problem/10844
 * 분류 : 다이나믹 프로그래밍
 * 
 * 문제 해설:
 * - 계단 수: 인접한 모든 자리의 차이가 1인 수 (예: 45656, 78987)
 * - N자리 계단 수의 개수를 구하는 문제
 * 
 * DP 설계:
 * - dp[i][j] = i자리 수에서 마지막 자리가 j인 계단 수의 개수
 * - 점화식: dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
 *   (j-1에서 올라오거나, j+1에서 내려올 수 있음)
 * - 경계 조건: 0은 1에서만, 9는 8에서만 올 수 있음
 * 
 * 예시 테이블 (자릿수별 마지막 숫자에 따른 경우의 수):
 * 자릿수 | 0  1  2  3  4  5  6  7  8  9 | 합계
 *   1    | 0  1  1  1  1  1  1  1  1  1 |  9  (맨 앞자리는 0이 될 수 없음)
 *   2    | 1  1  2  2  2  2  2  2  2  1 | 17
 *   3    | 1  3  3  4  4  4  4  4  3  2 | 32
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// dp[i][j] = i자리 수에서 마지막 자리가 j인 계단 수의 개수
		long[][] dp = new long[101][11];
		
		// 1자리 수 초기화: 1~9 각각 1개씩 (0으로 시작하는 수는 없음)
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;  // 1자리에서 0으로 시작할 수 없음
		
		// 2자리부터 N자리까지 DP 계산
		for (int i = 2; i <= n; i++) {
			// 0은 이전 자리가 1인 경우에만 가능
			dp[i][0] = dp[i - 1][1];
			
			// 1~8은 이전 자리가 j-1 또는 j+1인 경우 가능
			for (int j = 1; j < 9; j++) {
				long a = dp[i - 1][j - 1];  // j-1에서 올라온 경우
				long b = dp[i - 1][j + 1];  // j+1에서 내려온 경우
				dp[i][j] = (a + b) % 1000000000;
			}
			
			// 9는 이전 자리가 8인 경우에만 가능
			dp[i][9] = dp[i - 1][8];
		}
		
		// N자리 계단 수의 총 개수 계산 (맨 앞자리가 0인 경우 제외)
		long sum = 0;
		for (int i = 1; i < 10; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % 1000000000);
	}
}