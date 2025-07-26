/**
 * 백준 1008번: A/B
 * https://www.acmicpc.net/problem/1008
 * 
 * 문제 설명:
 * 두 정수 A와 B를 입력받아 A/B를 출력하는 문제
 * 실수 나눗셈의 결과를 출력해야 함
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 실수 자료형 (double)
 * - 실수 나눗셈 연산
 * - 조건문 (범위 검사)
 * 
 * 시간복잡도: O(1) - 단순 계산
 */
package p1008;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();  // 첫 번째 실수 입력
		double b = sc.nextDouble();  // 두 번째 실수 입력
		
		// 입력 범위 확인 후 나눗셈 결과 출력
		if(a > 0 && b < 10) {
			System.out.print(a/b);   // 실수 나눗셈 결과
		}
	}
}