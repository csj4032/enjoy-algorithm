package p2439;

import java.util.Scanner;

/**
 * 제목: 별 찍기 - 2
 * 링크: https://www.acmicpc.net/problem/2439
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 오른쪽 정렬된 직각삼각형 별 패턴 출력
 * - 1번째 줄: 공백(N-1)개 + *, 2번째 줄: 공백(N-2)개 + **, ...
 * - 예(N=5): "    *", "   **", "  ***", " ****", "*****"
 * 
 * 알고리즘 접근:
 * 1. 바깥쪽 루프: 0부터 N-1까지 반복 (i번째 줄)
 * 2. 안쪽 루프: N개의 위치를 순회
 * 3. 조건: j >= N-i-1이면 별, 그렇지 않으면 공백
 * 
 * 학습 개념:
 * - 조건문을 이용한 패턴 제어
 * - 공백과 별의 위치 계산
 * - 인덱스 관계를 이용한 패턴 생성
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 별 패턴의 크기
		
		// i번째 줄 (상단부터 0, 1, 2, ...)
		for (int i = 0; i < n; i++) {
			// 각 줄의 N개 위치 처리
			for (int j = 0; j < n; j++) {
				// j 위치가 별이 시작되는 위치보다 크거나 같으면 별 출력
				// i번째 줄에서 별은 (n-i-1)번째 위치부터 시작
				if (n - i - 1 <= j) {
					System.out.print("*");
				} else {
					System.out.print(" ");  // 공백 출력
				}
			}
			System.out.println();  // 줄바꿈
		}
	}
}