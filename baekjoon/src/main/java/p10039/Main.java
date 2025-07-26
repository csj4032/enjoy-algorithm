/**
 * 백준 10039번: 평균 점수
 * https://www.acmicpc.net/problem/10039
 * 
 * 문제 설명:
 * 5명의 학생이 시험을 치렀다. 
 * 40점 미만인 점수는 40점으로 보정하여 평균을 구하는 문제
 * 
 * 핵심 개념:
 * - 기본 입출력 (Scanner 사용)
 * - 반복문 (for문)
 * - 조건문 (삼항 연산자)
 * - 산술 연산 (덧셈, 나눗셈)
 * 
 * 시간복잡도: O(1) - 항상 5번 반복
 */
package p10039;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		// 5명의 점수를 입력받아 처리
		for (int i = 0; i < 5; i++) {
			int score = sc.nextInt();
			// 40점 미만이면 40점으로 보정, 아니면 원래 점수 사용
			sum += score < 40 ? 40 : score;
		}
		
		// 평균 계산 (정수 나눗셈)
		System.out.println(sum / 5);
	}
}