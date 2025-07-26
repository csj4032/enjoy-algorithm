/**
 * 백준 2753번: 윤년
 * https://www.acmicpc.net/problem/2753
 * 
 * 문제 설명:
 * 연도가 주어졌을 때, 윤년인지 판별하는 문제
 * 윤년 조건:
 * - 4로 나누어떨어지면서 100으로 나누어떨어지지 않거나
 * - 400으로 나누어떨어지면 윤년
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 조건문 (if-else)
 * - 나머지 연산자 (%)
 * - 논리 연산자 (&&, !=)
 * - 윤년의 수학적 규칙
 * 
 * 시간복잡도: O(1) - 단순 조건 확인
 */
package p2753;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 연도 입력

		// 윤년 판별 조건
		// 4로 나누어떨어지면서 100으로 나누어떨어지지 않는 경우
		if (n % 4 == 0 && n % 100 != 0) {
			System.out.println("1");  // 윤년
		} else {
			// 400으로 나누어떨어지는 경우도 윤년
			if (n % 400 == 0) {
				System.out.println("1");  // 윤년
			} else {
				System.out.println("0");  // 평년
			}
		}
	}
}