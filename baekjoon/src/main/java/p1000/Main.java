package p1000;

import java.util.Scanner;

/**
 * 백준 1000 - A+B
 * 분류: 수학, 구현, 사칙연산
 * 
 * 핵심 개념:
 * - 두 정수를 입력받아 합을 출력하는 가장 기본적인 문제
 * - 프로그래밍의 기초: 입력, 연산, 출력
 * 
 * 학습 포인트:
 * 1. Scanner를 이용한 정수 입력 받기
 * 2. 기본 사칙연산 (덧셈)
 * 3. System.out.println()을 이용한 출력
 * 4. 변수 선언과 사용
 * 
 * 예시:
 * - 입력: 1 2 → 출력: 3
 * - 입력: 3 4 → 출력: 7
 * 
 * 시간복잡도: O(1) - 상수 시간
 * 공간복잡도: O(1) - 상수 공간
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 두 정수 A, B 입력받기
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 두 수의 합 계산
		int sum = a + b;
		
		// 결과 출력
		System.out.println(sum);
	}
}