package p1476;

import java.util.Scanner;

/**
 * 백준 1476번: 날짜 계산 (Silver 5)
 * https://www.acmicpc.net/problem/1476
 * 
 * 문제 분류: 브루트포스, 수학, 중국인의 나머지 정리
 * 핵심 알고리즘: 순차 탐색 또는 중국인의 나머지 정리
 * 
 * 해결 접근 방법:
 * 1. 준규가 사용하는 달력은 3개의 주기를 가짐:
 *    - E: 15년 주기 (1~15)
 *    - S: 28년 주기 (1~28) 
 *    - M: 19년 주기 (1~19)
 * 2. 주어진 E, S, M 값에 해당하는 첫 번째 연도를 찾아야 함
 * 3. 브루트포스: 1년부터 시작해서 조건을 만족할 때까지 탐색
 * 4. 최적화: 중국인의 나머지 정리 사용 가능 (lcm(15,28,19) = 7980)
 * 
 * 시간복잡도: O(lcm(15,28,19)) = O(7980) - 최악의 경우
 * 공간복잡도: O(1)
 * 
 * 관련 개념:
 * - 합동식과 나머지 연산
 * - 중국인의 나머지 정리 (Chinese Remainder Theorem)
 * - 최소공배수 (LCM)
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt(); // 지구 (1~15)
		int S = sc.nextInt(); // 태양 (1~28)
		int M = sc.nextInt(); // 달 (1~19)
		
		int year = 1; // 1년부터 시작

		while (true) {
			// 현재 연도에서의 각 달력 값 계산
			int earthYear = year % 15;
			int sunYear = year % 28;
			int moonYear = year % 19;

			// 나머지가 0인 경우 해당 주기의 최대값으로 변경
			// (예: 15년째는 15%15=0이 아니라 15로 표현)
			if (earthYear == 0) earthYear = 15;
			if (sunYear == 0) sunYear = 28;
			if (moonYear == 0) moonYear = 19;

			// 목표 날짜와 일치하는지 확인
			if (earthYear == E && sunYear == S && moonYear == M) {
				System.out.println(year);
				break;
			}

			year++; // 다음 연도로 이동
		}
		
		/* 
		 * 최적화된 해법 (중국인의 나머지 정리):
		 * year ≡ E (mod 15)
		 * year ≡ S (mod 28) 
		 * year ≡ M (mod 19)
		 * 
		 * 이 연립 합동식을 풀면 한 번에 답을 구할 수 있음
		 * 하지만 브루트포스도 충분히 빠름 (최대 7980번 실행)
		 */
	}
}