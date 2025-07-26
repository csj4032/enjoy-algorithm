package p10992;

import java.util.Scanner;

/**
 * 제목: 별 찍기 - 17
 * 링크: https://www.acmicpc.net/problem/10992
 * 분류: 구현, 반복문
 * 
 * 핵심 아이디어:
 * - 속이 빈 이등변삼각형 테두리 별 패턴
 * - 첫 번째 줄에는 중앙에 별 1개
 * - 마지막 줄에는 전체를 별로 채움
 * - 나머지 줄에는 양끝에만 별을 배치
 * - 예(N=4): "   *", "  * *", " *   *", "*******"
 * 
 * 알고리즘 접근:
 * 1. 전체 폭: 2*N-1
 * 2. 마지막 줄(i == N-1): 모든 위치에 별
 * 3. 첫 번째 줄(i == 0): 중앙에만 별
 * 4. 나머지 줄: 양끝 경계에만 별
 * 
 * 학습 개념:
 * - 조건분기를 이용한 복합 패턴 처리
 * - 삼각형 테두리의 수학적 특성
 * - 경계 조건에 따른 다른 출력 로직
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 별 패턴의 크기
		int m = n * 2 - 1;    // 전체 폭

		// i번째 줄 (상단부터 0, 1, 2, ...)
		for (int i = 0; i < n; i++) {
			// 각 줄의 M개 위치 처리
			for (int j = 0; j < m; j++) {
				// 별을 출력하는 조건:
				// 1. 마지막 줄 (i == n-1): 모든 위치에 별
				// 2. 오른쪽 경계 (m - j == n - i): 삼각형의 오른쪽 변
				// 3. 왼쪽 경계 (n - j - 1 == i): 삼각형의 왼쪽 변
				if (i == n - 1 || m - j == n - i || n - j - 1 == i) {
					System.out.print("*");
				} else {
					// 별이 아닌 곳에서 삼각형 내부에만 공백 출력
					if (m - n + i > j) System.out.print(" ");
				}
			}
			System.out.println();  // 줄바꿈
		}
	}
}
