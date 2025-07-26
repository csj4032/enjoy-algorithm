package p6064;

import java.util.Scanner;

/**
 * 백준 6064번: 카잉 달력 (Silver 1)
 * https://www.acmicpc.net/problem/6064
 * 
 * 문제 분류: 브루트포스, 수학, 중국인의 나머지 정리
 * 핵심 알고리즘: 중국인의 나머지 정리 응용
 * 
 * 해결 접근 방법:
 * 1. 카잉달력의 마지막 해는 lcm(M, N)이다
 * 2. 찾는 연도를 k라 하면:
 *    - k ≡ x (mod M)
 *    - k ≡ y (mod N)
 * 3. 첫 번째 조건을 만족하는 수들: x, x+M, x+2M, ...
 * 4. 이 중에서 두 번째 조건도 만족하는 첫 번째 수를 찾음
 * 5. lcm(M, N)을 넘으면 해당 연도는 존재하지 않음
 * 
 * 시간복잡도: O(max(M, N)) - 최악의 경우 lcm까지 탐색
 * 공간복잡도: O(1)
 * 
 * 최적화 아이디어:
 * - 나이브한 브루트포스: O(lcm(M, N)) - 시간초과
 * - 개선된 방법: 한 조건을 만족하는 수만 확인 - O(max(M, N))
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for (int i = 0; i < T; i++) {
			int M = sc.nextInt(); // 첫 번째 달력의 최대값
			int N = sc.nextInt(); // 두 번째 달력의 최대값  
			int x = sc.nextInt(); // 찾는 첫 번째 달력 값
			int y = sc.nextInt(); // 찾는 두 번째 달력 값
			
			System.out.println(findCaingCalendar(M, N, x, y));
		}
	}

	/**
	 * 카잉 달력에서 <x:y>에 해당하는 연도를 찾는 함수
	 * 
	 * @param M 첫 번째 달력의 주기
	 * @param N 두 번째 달력의 주기
	 * @param x 찾는 첫 번째 달력 값
	 * @param y 찾는 두 번째 달력 값
	 * @return 해당하는 연도, 존재하지 않으면 -1
	 */
	private static int findCaingCalendar(int M, int N, int x, int y) {
		int lcm = lcm(M, N); // 카잉달력의 마지막 해
		
		// k ≡ x (mod M)을 만족하는 수들을 차례로 확인
		// x, x+M, x+2M, ... 형태로 진행
		for (int k = x; k <= lcm; k += M) {
			// k ≡ y (mod N)도 만족하는지 확인
			if ((k - 1) % N + 1 == y) {
				return k;
			}
		}
		
		return -1; // 해당하는 연도가 존재하지 않음
	}

	/**
	 * 최대공약수를 구하는 함수 (유클리드 호제법)
	 */
	private static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
	
	/**
	 * 최소공배수를 구하는 함수
	 */
	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}