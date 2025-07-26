/**
 * 백준 10101번: 삼각형 외우기
 * https://www.acmicpc.net/problem/10101
 * 
 * 문제 설명:
 * 삼각형의 세 각의 크기가 주어졌을 때, 삼각형의 종류를 판별하는 문제
 * - 정삼각형(Equilateral): 세 각이 모두 60도
 * - 이등변삼각형(Isosceles): 두 각이 같음
 * - 부등변삼각형(Scalene): 세 각이 모두 다름
 * - Error: 세 각의 합이 180도가 아닌 경우
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 조건문 (if-else if-else)
 * - 논리 연산자 (&&, ||)
 * - 삼각형의 성질 (내각의 합 = 180도)
 * 
 * 시간복잡도: O(1) - 단순 조건 확인
 */
package p10101;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();  // 첫 번째 각
		int b = sc.nextInt();  // 두 번째 각
		int c = sc.nextInt();  // 세 번째 각

		// 삼각형의 내각의 합은 반드시 180도여야 함
		if (a + b + c != 180) {
			System.out.println("Error");
		} else {
			// 세 각이 모두 같으면 정삼각형 (모든 각이 60도)
			if (a == b && a == c && b == c) {
				System.out.println("Equilateral");
			} 
			// 두 각이 같으면 이등변삼각형
			else if (a == b || a == c || b == c) {
				System.out.println("Isosceles");
			} 
			// 세 각이 모두 다르면 부등변삼각형
			else {
				System.out.println("Scalene");
			}
		}
	}
}