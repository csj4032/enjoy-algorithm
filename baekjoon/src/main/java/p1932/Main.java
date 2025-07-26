package p1932;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 백준 1932번: 정수 삼각형 (Silver 1)
 * https://www.acmicpc.net/problem/1932
 * 
 * == 문제 분류 ==
 * 동적 계획법, 경로 최적화
 * 
 * == 알고리즘 이론 ==
 * 1. 경로 최적화 문제
 *    - 삼각형 구조에서 최대 합 경로 찾기
 *    - 각 단계에서 직전 단계의 최적 선택 활용
 *    - 상향식 DP(Bottom-up)로 해결
 * 
 * 2. 2차원 DP 테이블
 *    - dp[i][j] = i번째 층, j번째 위치에서의 최대 합
 *    - 전이 방정식: dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
 * 
 * == 핵심 아이디어 ==
 * 1. 각 위치에서 도달 가능한 이전 위치 고려
 * 2. 상단에서 하단으로 순차적 계산
 * 3. 마지막 층에서 최대값 선택
 * 
 * == 시간복잡도 ==
 * O(n²) - 삼각형의 모든 원소 순회
 * 
 * == 공간복잡도 ==
 * O(n²) - 2차원 DP 배열
 * 
 * == 구현 최적화 기법 ==
 * 1. 1차원 배열로 공간 절약 가능
 * 2. In-place 계산으로 추가 메모리 절약
 * 3. 범위 검사로 안전성 보장
 * 
 * == 실무 응용 ==
 * - 의사결정 트리 최적화
 * - 게임 경로 찾기
 * - 투자 전략 최적화
 * 
 * == 관련 심화 문제 ==
 * - 백준 2579: 계단 오르기
 * - 백준 1149: RGB거리
 * - 백준 11057: 오르막 수
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] m = new int[n + 1][n + 1];
		int[][] l = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			m[0][i] = 0;
			l[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				m[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				l[i][j] = Math.max(l[i - 1][j - 1], l[i - 1][j]) + m[i][j];
			}
		}

		System.out.println(Arrays.stream(l[n]).max().getAsInt());
	}
}