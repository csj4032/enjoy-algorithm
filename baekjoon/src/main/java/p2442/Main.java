package p2442;

import java.util.Scanner;

/**
 * 제목: 별 찍기 - 5
 * 링크: https://www.acmicpc.net/problem/2442
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 이등변삼각형 별 패턴 출력 (가운데 정렬)
 * - 1번째 줄: 공백(N-1)개 + *, 2번째 줄: 공백(N-2)개 + ***, ...
 * - i번째 줄에는 (2*i-1)개의 별이 가운데 정렬
 * - 예(N=5): "    *", "   ***", "  *****", " *******", "*********"
 * 
 * 알고리즘 접근:
 * 1. 전체 폭: 2*N-1
 * 2. i번째 줄에서 별의 시작 위치: N-i-1
 * 3. i번째 줄에서 별의 끝 위치: N+i-1
 * 4. 범위 내에 있으면 별, 밖에 있으면 공백
 * 
 * 학습 개념:
 * - 대칭 패턴의 수학적 규칙
 * - 범위 조건을 이용한 패턴 생성
 * - 이등변삼각형의 기하학적 특성
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 별 패턴의 크기
		int m = 2 * n - 1;    // 전체 폭 (가장 아래쪽 줄의 별 개수)

		// i번째 줄 (상단부터 0, 1, 2, ...)
		for (int i = 0; i < n; i++) {
			// 각 줄의 M개 위치 처리
			for (int j = 0; j < m; j++) {
				// i번째 줄에서 별의 범위: [n-i-1, m-n+i]
				// 예: 0번째 줄에서 별의 범위: [n-1, n-1] (가운데 1개)
				if (n - i - 1 <= j && j <= m - n + i) {
					System.out.print("*");
				} else if (n - i > j) {
					// 별이 시작되기 전 위치에만 공백 출력
					System.out.print(" ");
				}
				// 별이 끝난 후에는 아무것도 출력하지 않음
			}
			System.out.println();  // 줄바꿈
		}
	}
}