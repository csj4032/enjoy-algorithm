package p1550;

import java.util.Scanner;

/**
 * 제목: 16진수
 * 링크: https://www.acmicpc.net/problem/1550
 * 분류: 수학, 진법 변환
 * 
 * 핵심 아이디어:
 * - 16진수로 주어진 수를 10진수로 변환하는 문제
 * - 16진수: 0-9, A-F를 사용 (A=10, B=11, C=12, D=13, E=14, F=15)
 * - 예: ABC(16) = 10*16^2 + 11*16^1 + 12*16^0 = 2748(10)
 * 
 * 알고리즘 접근:
 * 1. Java의 Integer.parseInt() 메서드 활용
 * 2. 두 번째 매개변수로 radix(16) 지정
 * 3. 자동으로 10진수로 변환되어 출력
 * 
 * 학습 개념:
 * - 진법 변환의 기본 원리
 * - Integer.parseInt()의 radix 매개변수 활용
 * - 16진수 표현법과 변환 과정
 */
public class Main {

	public static void main(String[] args) {
		// 16진수 문자열을 입력받아 10진수로 변환
		// Integer.parseInt(string, radix)를 사용
		// radix 16: 16진수로 해석하여 10진수로 변환
		System.out.println(Integer.parseInt(new Scanner(System.in).next(), 16));
	}
}
