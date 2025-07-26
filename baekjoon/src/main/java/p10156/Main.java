/**
 * 백준 10156번: 과자
 * https://www.acmicpc.net/problem/10156
 * 
 * 문제 설명:
 * 과자 한 개의 가격 k원, 사려고 하는 과자의 개수 n개, 현재 가진 돈 m원이 주어질 때,
 * 과자를 사기 위해 부모님께 받아야 하는 돈을 구하는 문제
 * 이미 충분한 돈이 있다면 0을 출력
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 사칙연산 (곱셈, 뺄셈)
 * - 조건문 (삼항 연산자)
 * - 실생활 수학 문제
 * 
 * 시간복잡도: O(1) - 단순 계산
 */
package p10156;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// k: 과자 한 개의 가격, n: 사려는 과자 개수, m: 현재 가진 돈
		// 필요한 돈 - 가진 돈 = 부족한 돈
		int g = sc.nextInt() * sc.nextInt() - sc.nextInt();
		
		// 부족한 돈이 음수(이미 충분함)면 0, 양수면 그 값 출력
		System.out.println(g < 0 ? 0 : g);
	}
}