/**
 * 백준 1075번: 나누기
 * https://www.acmicpc.net/problem/1075
 * 
 * 문제 설명:
 * 두 정수 N과 F가 주어졌을 때, N의 뒤 두 자리를 바꾸어서 F로 나누어떨어지게 만들고,
 * 그 뒤 두 자리를 00부터 99까지 중에서 가장 작은 값을 찾는 문제
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 나머지 연산 (모듈로 연산)
 * - 반복문을 이용한 완전탐색
 * - 문자열 포맷팅 (%02d로 두 자리 수 표현)
 * - 수학적 사고 (뒤 두 자리 조작)
 * 
 * 시간복잡도: O(100) = O(1) - 최대 100번 반복
 */
package p1075;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 주어진 수 N
		int f = sc.nextInt();  // 나누어야 할 수 F
		
		// N의 뒤 두 자리를 00으로 만듦 (나머지를 빼서 100의 배수로 만듦)
		n = n - n % 100;
		int i = 0;

		// 00부터 99까지 시도하여 F로 나누어떨어지는 가장 작은 수 찾기
		for (int j = 0; j < 100; j++) {
			if ((n + j) % f == 0) {  // F로 나누어떨어지면
				break;               // 찾았으므로 종료
			}
			i++;  // 시도 횟수 증가
		}

		// 결과를 두 자리 수로 포맷팅하여 출력 (01, 02, ..., 99)
		System.out.println(String.format("%02d", i));
	}
}
