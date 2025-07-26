package p2438;

import java.util.Scanner;

/**
 * 제목: 별 찍기 - 1
 * 링크: https://www.acmicpc.net/problem/2438
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 왼쪽 정렬된 직각삼각형 별 패턴 출력
 * - 1번째 줄: *, 2번째 줄: **, ..., N번째 줄: N개의 *
 * - 예(N=5): *, **, ***, ****, *****
 * 
 * 알고리즘 접근:
 * 1. 바깥쪽 루프: 1부터 N까지 반복 (i번째 줄)
 * 2. 안쪽 루프: i번 별(*) 출력
 * 3. 각 줄마다 줄바꿈 출력
 * 
 * 학습 개념:
 * - 중첩된 반복문의 기본 구조
 * - 패턴 인식과 반복 변수 활용
 * - 예술적 출력을 위한 기본 알고리즘
 */
public class Main {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();  // 별 패턴의 크기
		
		// i번째 줄에 i개의 별 출력
		for (int i = 1; i <= n; i++) {
			// 현재 줄에서 i개의 별 출력
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();  // 줄바꿈
		}
	}
}