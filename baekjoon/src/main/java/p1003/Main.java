package p1003;

import java.util.Scanner;

/**
 * 백준 1003번: 피보나치 함수 (Silver 3)
 * https://www.acmicpc.net/problem/1003
 * 
 * 문제 분류: 동적 계획법(DP), 메모이제이션
 * 핵심 알고리즘: Bottom-up DP로 0과 1 호출횟수 계산
 * 
 * 해결 접근 방법:
 * 1. 피보나치 함수에서 0과 1이 각각 몇 번 호출되는지 패턴 분석
 * 2. fibonacci(0) = 0 → 0이 1번, 1이 0번 호출
 * 3. fibonacci(1) = 1 → 0이 0번, 1이 1번 호출  
 * 4. fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
 *    → 0 호출횟수도 f(n-1) + f(n-2), 1 호출횟수도 f(n-1) + f(n-2)
 * 5. 즉, 0과 1의 호출횟수 자체가 피보나치 수열을 따름
 * 
 * 시간복잡도: O(N) - 각 테스트케이스마다 최대 N번 계산
 * 공간복잡도: O(N) - DP 테이블 저장
 * 
 * DP 개념:
 * - Overlapping Subproblems: 같은 부분문제가 반복 등장
 * - Optimal Substructure: 최적해가 부분문제의 최적해로 구성
 * - Memoization vs Tabulation: Bottom-up 방식 사용
 */
public class Main {

	// 0과 1의 호출 횟수를 저장하는 배열 (최대 40까지)
	static int[] zeroCount = new int[41]; // 0 호출 횟수
	static int[] oneCount = new int[41];  // 1 호출 횟수

	public static void main(String[] args) {
		// Base case 초기화
		zeroCount[0] = 1; // fibonacci(0)에서 0이 1번 호출
		zeroCount[1] = 0; // fibonacci(1)에서 0이 0번 호출

		oneCount[0] = 0;  // fibonacci(0)에서 1이 0번 호출
		oneCount[1] = 1;  // fibonacci(1)에서 1이 1번 호출

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			
			// N까지의 0과 1 호출횟수를 Bottom-up 방식으로 계산
			for (int i = 2; i <= N; i++) {
				// fibonacci(i) = fibonacci(i-1) + fibonacci(i-2)
				// 따라서 0 호출횟수도 동일한 점화식을 따름
				zeroCount[i] = zeroCount[i-1] + zeroCount[i-2];
				oneCount[i] = oneCount[i-1] + oneCount[i-2];
			}
			
			System.out.println(zeroCount[N] + " " + oneCount[N]);
		}
		
		sc.close();
	}
}