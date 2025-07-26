package p2441;

import java.util.Scanner;

/**
 * 제목: 별 찍기 - 4
 * 링크: https://www.acmicpc.net/problem/2441
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 오른쪽 정렬된 역직각삼각형 별 패턴 출력
 * - 1번째 줄: N개의 *, 2번째 줄: 공백 1개 + (N-1)개의 *, ...
 * - 예(N=5): "*****", " ****", "  ***", "   **", "    *"
 * 
 * 알고리즘 접근:
 * 1. 바깥쪽 루프: 0부터 N-1까지 반복 (i번째 줄)
 * 2. 안쪽 루프: N개의 위치를 순회
 * 3. 조건: j >= i이면 별, j < i이면 공백
 * 
 * 학습 개념:
 * - 공백과 별의 조합으로 오른쪽 정렬 효과
 * - 역순 패턴에서의 정렬 변화
 * - 인덱스 관계를 이용한 조건 분기
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
				if (i <= j) {
					System.out.print("*");
				} else {
					// j < i이면 공백 출력 (오른쪽 정렬 효과)
					System.out.print(" ");
				}
			}
			System.out.println();  // 줄바꿈
		}
	}
}
