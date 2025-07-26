package p9461;

import java.util.Scanner;

/**
 * 백준 9461번: 파도반 수열 (Silver 3)
 * https://www.acmicpc.net/problem/9461
 * 
 * 문제 분류: 동적 계획법(DP)
 * 핵심 알고리즘: Bottom-up DP로 파도반 수열 계산
 * 
 * 해결 접근 방법:
 * 1. 파도반 수열의 패턴 분석:
 *    P(1)=1, P(2)=1, P(3)=1, P(4)=2, P(5)=2, P(6)=3, P(7)=4, P(8)=5, P(9)=7, P(10)=9
 * 2. 점화식 발견: P(n) = P(n-2) + P(n-3) (n ≥ 4)
 * 3. 삼각형 나선에서 각 변의 길이가 파도반 수열을 이룸
 * 4. 초기값 설정 후 점화식으로 모든 값을 미리 계산
 * 
 * 시간복잡도: O(N) - 전처리 한 번으로 모든 쿼리 O(1) 처리
 * 공간복잡도: O(N) - DP 테이블 저장
 * 
 * 주의사항:
 * - N이 최대 100이고 값이 매우 커질 수 있으므로 long 타입 사용
 * - static 초기화로 전처리하여 성능 최적화
 * 
 * 파도반 수열 특징:
 * - 피보나치 수열의 변형
 * - 삼각형 나선의 변의 길이와 관련
 * - P(n) = P(n-2) + P(n-3) 점화식 사용
 */
public class Main {

	// 파도반 수열을 저장하는 배열 (최대 100까지)
	static long[] P = new long[101];
	static StringBuilder sb = new StringBuilder();

	// static 초기화 블록으로 파도반 수열 전처리
	static {
		// Base cases
		P[1] = 1;
		P[2] = 1; 
		P[3] = 1;
		
		// 점화식: P(n) = P(n-2) + P(n-3) (n ≥ 4)
		for (int i = 4; i <= 100; i++) {
			P[i] = P[i - 2] + P[i - 3];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			sb.append(P[N]).append("\n"); // 미리 계산된 값 사용 (O(1))
		}
		
		System.out.print(sb.toString());
		sc.close();
	}
}
