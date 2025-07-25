package p1001;

import java.util.Scanner;

/**
 * 제목 : A-B
 * 링크 : https://www.acmicpc.net/problem/1001
 * 분류 : 사칙연산, 수학
 * 
 * 문제 해설:
 * - 두 정수 A와 B를 입력받아 A-B를 출력하는 기본적인 입출력 문제
 * - 경쟁 프로그래밍의 가장 기초적인 유형
 * - Scanner를 사용한 표준 입력 처리 방법을 익히는 문제
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();  // 첫 번째 정수 입력
		int b = sc.nextInt();  // 두 번째 정수 입력
		System.out.println(a - b);  // 뺄셈 결과 출력
	}
}