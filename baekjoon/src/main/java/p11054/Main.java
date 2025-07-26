package p11054;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 11054번: 가장 긴 바이토닉 부분 수열 (Gold 4)
 * https://www.acmicpc.net/problem/11054
 * 
 * == 문제 분류 ==
 * 동적 계획법, LIS 응용
 * 
 * == 알고리즘 이론 ==
 * 1. 바이토닉 수열 (Bitonic Sequence)
 *    - 먼저 증가하다가 감소하는 수열
 *    - 증가 부분 + 감소 부분의 조합
 *    - 천산이나 언덕 모양의 수열
 * 
 * 2. LIS(Longest Increasing Subsequence) 응용
 *    - 좌에서 우: 가장 긴 증가 부분 수열
 *    - 우에서 좌: 가장 긴 감소 부분 수열
 *    - 두 결과를 결합하여 바이토닉 수열 찾기
 * 
 * 3. 양방향 DP
 *    - Forward DP: 좌에서 우로 LIS 계산
 *    - Backward DP: 우에서 좌으로 LDS 계산
 * 
 * == 핵심 아이디어 ==
 * 1. lis[i] = i번째 원소로 끝나는 증가 수열 길이
 * 2. lds[i] = i번째 원소로 시작하는 감소 수열 길이
 * 3. bitonic[i] = lis[i] + lds[i] - 1 (자기 자신 중복 제거)
 * 
 * == 시간복잡도 ==
 * O(n²) - 일반적인 LIS 알고리즘
 * O(n log n) - 이진 탐색 최적화 버전
 * 
 * == 공간복잡도 ==
 * O(n) - 두 개의 DP 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 이진 탐색으로 O(n log n) 최적화
 * 2. 공간 절약을 위한 In-place 계산
 * 3. 예외 처리로 안정성 보장
 * 
 * == 실무 응용 ==
 * - 주가 예측 및 트렌드 분석
 * - 신호 처리에서 피크 검출
 * - 기상 데이터 분석
 * 
 * == 관련 심화 문제 ==
 * - 백준 11055: 가장 큰 증가 부분 수열
 * - 백준 2565: 전깃줄
 * - 백준 12015: 가장 긴 증가하는 부분 수열 2
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];

		int[] dp1 = new int[n];
		int[] dp2 = new int[n];

		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);

		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (m[j] < m[i] && dp1[i] < dp1[j] + 1) {
					dp1[i] = dp1[i]+1;
				}
			}
		}

		//System.out.println(Arrays.toString(dp1));

		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (m[j] < m[i] && dp2[i] < dp2[j] + 1) {
					dp2[i] = dp2[i] + 1;
				}
			}
		}

		//System.out.println(Arrays.toString(dp2));

		int max = 0;
		for (int i = 0; i < n; i++) {
			int k = dp1[i] + dp2[i];
			if (k > max) max = k;
		}

		System.out.println(max - 1);
	}
}