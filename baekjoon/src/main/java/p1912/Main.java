package p1912;

import java.util.Scanner;

/**
 * 백준 1912번: 연속합 (Silver 2)
 * https://www.acmicpc.net/problem/1912
 * 
 * 문제 분류: 동적 계획법(DP), 카데인 알고리즘(Kadane's Algorithm)
 * 핵심 알고리즘: 1차원 DP로 최대 부분 배열 합 구하기
 * 
 * 해결 접근 방법:
 * 1. dp[i] = i번째 원소에서 끝나는 연속 부분 수열의 최대 합
 * 2. 점화식: dp[i] = max(arr[i], dp[i-1] + arr[i])
 *    - arr[i]: 새로운 부분 수열 시작
 *    - dp[i-1] + arr[i]: 이전 부분 수열에 현재 원소 추가
 * 3. 각 단계에서 전체 최대값을 갱신
 * 
 * 시간복잡도: O(N) - 배열을 한 번만 순회
 * 공간복잡도: O(N) - DP 테이블 (O(1)로 최적화 가능)
 * 
 * 카데인 알고리즘 (Kadane's Algorithm):
 * - 최대 부분 배열 합을 구하는 유명한 알고리즘
 * - 음수가 포함된 배열에서도 효과적으로 동작
 * - 현재까지의 합이 음수가 되면 버리고 새로 시작하는 아이디어
 * 
 * 관련 문제:
 * - 최대 부분 배열 문제의 기본형
 * - 2차원 확장 가능 (최대 부분 행렬)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n]; // dp[i] = i번째에서 끝나는 연속 부분 수열의 최대 합

		// 배열 입력
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 초기값: 첫 번째 원소
		dp[0] = arr[0];
		int maxSum = dp[0]; // 전체 최대값 추적

		// DP로 연속합 계산
		for (int i = 1; i < n; i++) {
			// 핵심 점화식: 이전까지의 합에 현재 원소를 더할지, 새로 시작할지 결정
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
			
			// 전체 최대값 갱신
			maxSum = Math.max(maxSum, dp[i]);
		}

		System.out.println(maxSum);
		sc.close();
	}
	
	/* 
	 * 공간 최적화된 버전 (O(1) 공간):
	 * 
	 * int currentSum = arr[0];
	 * int maxSum = arr[0];
	 * 
	 * for (int i = 1; i < n; i++) {
	 *     currentSum = Math.max(arr[i], currentSum + arr[i]);
	 *     maxSum = Math.max(maxSum, currentSum);
	 * }
	 */
}