package p2440;

import java.util.Scanner;

/**
 * 제목: 별 찍기 - 3
 * 링크: https://www.acmicpc.net/problem/2440
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 왼쪽 정렬된 역직각삼각형 별 패턴 출력
 * - 1번째 줄: N개의 *, 2번째 줄: (N-1)개의 *, ..., N번째 줄: 1개의 *
 * - 예(N=5): "*****", "****", "***", "**", "*"
 * 
 * 알고리즘 접근:
 * 1. 바깥쪽 루프: 0부터 N-1까지 반복 (i번째 줄)
 * 2. 안쪽 루프: N개의 위치를 순회
 * 3. 조건: j >= i이면 별 출력 (i가 증가할수록 별 개수 감소)
 * 
 * 학습 개념:
 * - 역순 패턴 생성
 * - 인덱스 비교를 이용한 출력 제어
 * - 감소하는 패턴의 수학적 관계
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 별 패턴의 크기
		
		// i번째 줄 (상단부터 0, 1, 2, ...)
		for (int i = 0; i < n; i++) {
			// 각 줄의 N개 위치 처리
			for (int j = 0; j < n; j++) {
				// j 위치가 i보다 크거나 같으면 별 출력
				// i가 커질수록 별의 개수는 줄어듦
				if (i <= j) {
					System.out.print("*");
				}
				// else 부분에서 공백을 출력하지 않아 좋음
			}
			System.out.println();  // 줄바꿈
		}
	}
}