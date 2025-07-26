package p1330;

import java.util.Scanner;

/**
 * 제목: 두 수 비교하기
 * 링크: https://www.acmicpc.net/problem/1330
 * 분류: 구현, 조건문
 * 
 * 핵심 아이디어:
 * - 두 정수 A와 B를 비교하여 관계를 출력하는 간단한 문제
 * - A > B이면 ">", A < B이면 "<", A == B이면 "==" 출력
 * 
 * 알고리즘 접근:
 * 1. 두 정수 A, B를 입력받음
 * 2. 삼항 연산자를 이용하여 비교 결과 출력
 * 3. 중첩된 삼항 연산자로 간결하게 처리
 * 
 * 학습 개념:
 * - 삼항 연산자(? :)의 사용법
 * - 조건문을 이용한 간단한 비교 로직
 * - 중첩된 삼항 연산자인 코드 작성
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();  // 첫 번째 정수
		int b = sc.nextInt();  // 두 번째 정수
		
		// 삼항 연산자를 이용한 비교 결과 출력
		// a > b이면 ">", 아니면 a < b인지 확인하여 "<" 또는 "==" 출력
		System.out.println(a > b ? ">" : a < b ? "<" : "==");
	}
}
